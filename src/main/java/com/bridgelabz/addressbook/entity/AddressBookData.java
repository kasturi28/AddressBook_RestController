package com.bridgelabz.addressbook.entity;


import com.bridgelabz.addressbook.dto.AddressBookDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Table(name = "addressbook_table")
public @Data class AddressBookData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstName;
    private String lastName;

    private String contactNumber;
    private String email;
    private String address;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;
    private String pinCode;

    public AddressBookData(AddressBookDTO addressBookDTO){
        this.firstName = addressBookDTO.getFirstName();
        this.lastName = addressBookDTO.getLastName();
        this.contactNumber = addressBookDTO.getContactNumber();
        this.email = addressBookDTO.getEmail();
        this.address = addressBookDTO.getAddress();
        this.city = addressBookDTO.getCity();
        this.state = addressBookDTO.getState();
        this.pinCode = addressBookDTO.getPinCode();
    }
}
