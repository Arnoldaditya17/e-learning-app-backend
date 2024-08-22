package com.example.app.E_Learning_Application.entities;


import com.example.app.E_Learning_Application.enums.UserRole;
import com.example.app.E_Learning_Application.enums.UserStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @Column(name = "user_id")
    private String id;

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private String phone;

    private String address;

    private UserStatus status;

    private String recentOTP;

    private UserRole userRole;

    private boolean emailVerified;

    private boolean smsVerified;

    private String profilePicture;


}
