package com.bridgelabz.addressbook.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@NoArgsConstructor
@AllArgsConstructor
public @Data class AddressBookDTO {
    @NotEmpty(message = "First name cannot be empty")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "First name Invalid")
    private String firstName;

    @NotEmpty(message = "Last name cannot be empty")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Last name Invalid")
    private String lastName;

    @NotEmpty(message = "Contact number cannot be empty")
    @Size(min = 10,max = 10, message = "Contact number must be 10 digits")
    private String contactNumber;

    @Email(message = "Enter correct email address")
    private String email;

    @NotEmpty(message = "Address cannot be empty")
    private String address;

    @NotEmpty(message = "City cannot be empty")
    private String city;

    @NotEmpty(message = "State cannot be empty")
    private String state;

    @Size(min = 6,max = 6, message = "Pin code must be of 6 digits")
    private String pinCode;
}