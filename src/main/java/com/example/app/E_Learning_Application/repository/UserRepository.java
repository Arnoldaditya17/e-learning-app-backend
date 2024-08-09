package com.example.app.E_Learning_Application.repository;

import com.example.app.E_Learning_Application.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {


}
