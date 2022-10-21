package com.bridgelabz.addressbook.service;

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.entity.AddressBookData;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IAddressBookService {
    ResponseEntity<List<AddressBookData>> getAddressBookData();
    ResponseEntity<AddressBookData> getAddressBookDataById(int id);
    ResponseEntity<AddressBookData> createAddressBookData(AddressBookDTO addressBookDTO);
    ResponseEntity<AddressBookData> updateAddressBookData(int id, AddressBookDTO addressBookDTO);

    ResponseEntity<String> deleteAddressBookData(int id);
}