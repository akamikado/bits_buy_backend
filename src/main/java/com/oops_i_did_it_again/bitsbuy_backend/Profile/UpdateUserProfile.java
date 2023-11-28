package com.oops_i_did_it_again.bitsbuy_backend.Profile;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.oops_i_did_it_again.bitsbuy_backend.mysqlaccess.Users;

import java.util.*;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UpdateUserProfile extends CrudRepository<Users, Integer> {
    
    @Modifying
    @Query(value = "UPDATE users SET name=:name, mobile_no=:mobile_no WHERE email=:email;", nativeQuery = true)
    void updatingNameMobileNo(@Param("email") String email,@Param("name") String name,@Param("mobile_no") Integer mobile_no);

    @Query(value = "SELECT u FROM Users u WHERE u.email = :email")
    List<Users> checkEmail(@Param("email") String email);

    @Modifying
    @Query(value = "INSERT INTO users (email) VALUES (:email);", nativeQuery = true)
    void createUser (@Param("email") String email);
}
