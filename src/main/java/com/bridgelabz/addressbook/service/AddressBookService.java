package com.bridgelabz.addressbook.service;


import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.entity.AddressBookData;
import com.bridgelabz.addressbook.repository.AddressBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class AddressBookService implements IAddressBookService{

    List<AddressBookData> addressBookDataList = new ArrayList<>();

    @Autowired
    private AddressBookRepository addressBookRepository;

    /**
     * Method to get all the AddressBook data from Database
     */
    @Override
    public ResponseEntity<List<AddressBookData>> getAddressBookData() {
        return new ResponseEntity<>(addressBookRepository.findAll(), HttpStatus.OK);
    }

    /**
     *
     * @param id
     * Method to get an AddressBook Data using id from the Database
     */
    @Override
    public ResponseEntity<AddressBookData> getAddressBookDataById(int id) {
        AddressBookData addressBookData = addressBookRepository.findById(id).orElse(null);
        return new ResponseEntity<>(addressBookData,HttpStatus.OK);
    }



    @Override
    public List<AddressBookData> sortAddressBookDataByCity() {
        return addressBookRepository.sortByCity();
    }

    @Override
    public List<AddressBookData> sortAddressBookDataByState() {
        return addressBookRepository.sortByState();
    }

    /**
     *
     * @param addressBookDTO
     * Method to Create an AddressBook Data to the Database
     */
    @Override
    public ResponseEntity<AddressBookData> createAddressBookData(AddressBookDTO addressBookDTO) {
        AddressBookData addressBookData =new AddressBookData(addressBookDTO);
        addressBookRepository.save(addressBookData);
        return new ResponseEntity<>(addressBookData,HttpStatus.OK);
    }

    /**
     *
     * @param id
     * @param addressBookDTO
     * Method to update an AddressBook Data from Database
     */
    @Override
    public ResponseEntity<AddressBookData> updateAddressBookData(int id, AddressBookDTO addressBookDTO) {
        AddressBookData addressBook = addressBookRepository.findById(id).orElse(null);
        if (addressBook != null){
            addressBook.setFirstName(addressBookDTO.getFirstName());
            addressBook.setLastName(addressBookDTO.getLastName());
            addressBook.setContactNumber(addressBookDTO.getContactNumber());
            addressBook.setEmail(addressBookDTO.getEmail());
            addressBook.setAddress(addressBookDTO.getAddress());
            addressBook.setCity(addressBookDTO.getCity());
            addressBook.setState(addressBookDTO.getState());
            addressBook.setPinCode(addressBookDTO.getPinCode());
            addressBookRepository.save(addressBook);
        }
        return new ResponseEntity<>(addressBook, HttpStatus.OK);
    }

    /**
     *
     * @param id
     * Method to Delete an AddressBook Data from the Database
     */
    @Override
    public ResponseEntity<String> deleteAddressBookData(int id) {
        addressBookRepository.deleteById(id);
        return new ResponseEntity<>("Deleted address book data for id : " +id, HttpStatus.OK);
}
}

