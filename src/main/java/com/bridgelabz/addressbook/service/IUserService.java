package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.UserRegistrationDTO;
import com.bridgelabz.addressbook.entity.User;

public interface IUserService {
    /**
     *
     * @param userRegistrationDTO
     * @return
     */
    User createUserRegistration(UserRegistrationDTO userRegistrationDTO);

    /**
     *
     * @param userName
     * @param password
     * @return
     */
    User loginAccount(String userName, String password);
}
