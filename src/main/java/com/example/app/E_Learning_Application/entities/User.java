package com.example.app.E_Learning_Application.entities;


import com.example.app.E_Learning_Application.enums.UserRole;
import com.example.app.E_Learning_Application.enums.UserStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "users")
@Data
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

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
