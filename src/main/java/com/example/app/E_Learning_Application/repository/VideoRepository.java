package com.example.app.E_Learning_Application.repository;

import com.example.app.E_Learning_Application.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends JpaRepository<Video, String> {
}
