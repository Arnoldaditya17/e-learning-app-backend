package com.example.app.E_Learning_Application.services;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    String uploadImage(MultipartFile file,String folderName);
}
