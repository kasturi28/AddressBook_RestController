package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.UserRegistrationDTO;
import com.bridgelabz.addressbook.entity.User;
import com.bridgelabz.addressbook.exception.UserException;
import com.bridgelabz.addressbook.repository.UserRepository;
import com.bridgelabz.addressbook.utility.EmailSenderService;
import com.bridgelabz.addressbook.utility.JwtToken;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    @Autowired
    UserRepository userRepository;

    @Autowired
    private JwtToken jwtToken;

    @Autowired
    EmailSenderService sender;

    public String createUserRegistration(UserRegistrationDTO userRegistrationDTO) {
        User user= null;
        user = new User(userRegistrationDTO);
        userRepository.save(user);
        sender.sendEmail(user.getUserEmail(), "Test Email", "User Registration done successfully..");
        return jwtToken.createToken(user.getUserId());
    }

//    @Override
//    public User loginAccount(String userName, String password) {
//
//        return userRepository.checkLogin(userName,password);
//    }

    @Override
    public User loginAccount(String token) {
        int userId = jwtToken.decodeJWT(token);
        return userRepository.findById(userId).orElseThrow(() -> new UserException("User does not exist"));
    }
}
