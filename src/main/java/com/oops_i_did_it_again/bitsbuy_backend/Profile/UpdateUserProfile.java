package com.oops_i_did_it_again.bitsbuy_backend.Profile;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.oops_i_did_it_again.bitsbuy_backend.mysqlaccess.Users;

import java.util.*;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UpdateUserProfile extends CrudRepository<Users, Integer> {

    @Query("UPDATE users SET name=:name, mobile_no=:moobile_no, hostel=:hostel WHERE email=:email;")
    Users updatingNameMobileNo(@Param("email") String email,@Param("name") String name,@Param("mobile_no") Integer mobile_no,@Param("hostel") String hostel);

    @Query("SELECT * FROM users WHERE email=:email;")
    List<Users> checkEmail(@Param("email") String email);

    @Query("INSERT INTO users (email) VALUES (:email);")
    Users createUser (@Param("email") String email);
}
