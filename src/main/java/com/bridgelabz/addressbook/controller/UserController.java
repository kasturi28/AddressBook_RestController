package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.dto.ResponseDTO;
import com.bridgelabz.addressbook.dto.UserRegistrationDTO;
import com.bridgelabz.addressbook.entity.User;
import com.bridgelabz.addressbook.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
    /**
     * Autowired User Services for using again and again.
     */
    @Autowired
    IUserService userService;

    /**
     *
     * @param userRegistrationDTO
     * @return ResponseEntity
     */
    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> registerAccount(@Valid @RequestBody UserRegistrationDTO userRegistrationDTO){
        ResponseDTO responseDTO = new ResponseDTO("User has been registered", userService.createUserRegistration(userRegistrationDTO));
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     *
     * @param userName
     * @param password
     * @return ResponseEntity
     */

    @GetMapping("/login")
    public ResponseEntity<ResponseDTO> loginAccount(@Valid @RequestHeader String token){
        User user = null;
        user = userService.loginAccount(token);
        ResponseDTO responseDTO = new ResponseDTO("Account Successfully Logged In",user);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }
}
