package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.UserRegistrationDTO;
import com.bridgelabz.addressbook.entity.User;

public interface IUserService {
    /**
     * @param userRegistrationDTO
     * @return
     */
    String createUserRegistration(UserRegistrationDTO userRegistrationDTO);

    /**
     *
     * @param userName
     * @param password
     * @return
     */
    User loginAccount(String token);
}
