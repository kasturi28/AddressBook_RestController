package com.bridgelabz.addressbook.entity;

import com.bridgelabz.addressbook.dto.UserRegistrationDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_data")
public @Data class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    @Column(name = "user_name")
    private String userName;
    private String userEmail;
    @Column(name = "password")
    private String password;

    /**
     *
     * @param userRegistrationDTO
     */
    public User(UserRegistrationDTO userRegistrationDTO) {
        this.userName = userRegistrationDTO.getUserName();
        this.userEmail = userRegistrationDTO.getUserEmail();
        this.password = userRegistrationDTO.getPassword();
    }
}
