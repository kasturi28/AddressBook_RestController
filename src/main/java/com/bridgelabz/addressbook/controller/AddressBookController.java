package com.bridgelabz.addressbook.controller;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.entity.AddressBookData;
import com.bridgelabz.addressbook.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AddressBookController {

    @Autowired
    private IAddressBookService addressBookService;

    /**
     * Getting all the Address Book Data from Database
     */
    @GetMapping(value = {"/getall"})
    public ResponseEntity<List<AddressBookData>> getAddressBookData() {
        return addressBookService.getAddressBookData();
    }

    /**
     *
     * @param id
     * Getting an AddressBook data by id from the Database
     */
    @GetMapping("/get/{id}")
    public ResponseEntity<AddressBookData> getAddressBookData(@PathVariable("id") int id) {
        return addressBookService.getAddressBookDataById(id);
    }

    /**
     *
     * @param addressBookDTO
     * Creating an AddressBook Data and save to the Database
     */
    @PostMapping("/create")
    public ResponseEntity<AddressBookData> addAddressBookData(@Valid @RequestBody AddressBookDTO addressBookDTO) {
        return addressBookService.createAddressBookData(addressBookDTO);
    }

    /**
     *
     * @param id
     * @param addressBookDTO
     * Updating an AddressBook data by id from the Database
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<AddressBookData> updateAddressBookData(@PathVariable("id") int id,
                                                                 @Valid @RequestBody AddressBookDTO addressBookDTO) {
        return addressBookService.updateAddressBookData(id,addressBookDTO);
    }

    /**
     *
     * @param id
     * Deleting an AddressBook Data from the Database
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAddressBookData(@PathVariable("id") int id) {
        return addressBookService.deleteAddressBookData(id);
    }
}