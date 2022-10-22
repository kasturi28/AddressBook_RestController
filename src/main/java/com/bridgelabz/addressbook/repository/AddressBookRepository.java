package com.bridgelabz.addressbook.repository;

import com.bridgelabz.addressbook.entity.AddressBookData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressBookRepository extends JpaRepository<AddressBookData, Integer> {

    /**
     *
     * @return sorted list of address book data by city
     */
    @Query(value = "select * from addressbook_table order by city ",nativeQuery = true)
    List<AddressBookData> sortByCity();

    /**
     *
     * @return sorted list of address book data by state
     */
    @Query(value = "select * from addressbook_table order by state ",nativeQuery = true)
    List<AddressBookData> sortByState();

}
