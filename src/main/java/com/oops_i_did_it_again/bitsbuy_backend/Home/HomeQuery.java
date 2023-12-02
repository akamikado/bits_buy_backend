package com.oops_i_did_it_again.bitsbuy_backend.Home;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.oops_i_did_it_again.bitsbuy_backend.mysqlaccess.Products;

import java.util.*;

public interface HomeQuery extends CrudRepository<Products, Integer> {
    @Query("SELECT p FROM Products p")
    List<Products> selectProducts();
}

