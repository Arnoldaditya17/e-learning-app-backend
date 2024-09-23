package com.example.app.E_Learning_Application.services;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.example.app.E_Learning_Application.exceptions.ImageUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private AmazonS3 client;

    @Value("${app.s3.bucket}")
    private  String bucketName;

    @Override
    public String uploadImage(MultipartFile file,String folderName) {
        String actualFileName = file.getOriginalFilename();
        assert actualFileName != null;
        String folderPath = folderName + "/";
        // Generate a unique file name
        String fileName = folderPath+UUID.randomUUID().toString() + actualFileName.substring(actualFileName.lastIndexOf("."));
        String fileType = getFileExtension(file);
        String contentType = switch (fileType) {
            case "jpeg", "jpg" -> "image/jpeg";
            case "png" -> "image/png";
            case "webp" -> "image/webp";
            default -> "application/octet-stream";
        };

        ObjectMetadata metaData = new ObjectMetadata();
        metaData.setContentLength(file.getSize());
        metaData.setContentType(fileType);

        try {
            client.putObject(new PutObjectRequest(bucketName, fileName, file.getInputStream(), metaData));
            return "https://" + bucketName + ".s3.amazonaws.com/" + fileName; // Return the URL of the uploaded image
        } catch (IOException e) {
            throw new ImageUploadException("Error in uploading image: " + e.getMessage());
        }
    }

    public static String getFileExtension(MultipartFile file) {
        String fileName = file.getName();
        int lastIndexOfDot = fileName.lastIndexOf('.');
        // Check if dot is present and it's not the first character
        if (lastIndexOfDot > 0 && lastIndexOfDot < fileName.length() - 1) {
            return fileName.substring(lastIndexOfDot + 1).toLowerCase(); // Return extension in lowercase
        } else {
            return ""; // Return empty string if no extension found
        }
    }

}
