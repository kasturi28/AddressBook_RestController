package com.bridgelabz.addressbook.repository;

import com.bridgelabz.addressbook.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User , Integer> {

    /**
     *
     * @param userName
     * @param password
     * @return
     */
    @Query(value = "select * from user_data where user_name = :userName and password = :password",nativeQuery = true)
    User checkLogin(String userName, String password);
}
