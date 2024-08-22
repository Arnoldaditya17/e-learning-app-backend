package com.example.app.E_Learning_Application.repositories;

import com.example.app.E_Learning_Application.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {


}
