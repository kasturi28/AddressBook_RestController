package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.UserRegistrationDTO;
import com.bridgelabz.addressbook.entity.User;
import com.bridgelabz.addressbook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    @Autowired
    UserRepository userRepository;
    public User createUserRegistration(UserRegistrationDTO userRegistrationDTO) {
        User user= null;
        user = new User(userRegistrationDTO);
        return userRepository.save(user);
    }

    @Override
    public User loginAccount(String userName, String password) {
        return userRepository.checkLogin(userName,password);
    }

    ;
}
