package com.oops_i_did_it_again.bitsbuy_backend.SearchPage;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.oops_i_did_it_again.bitsbuy_backend.mysqlaccess.Products;
import com.oops_i_did_it_again.bitsbuy_backend.mysqlaccess.Users;

import java.util.*;

public interface SearchQuery extends CrudRepository<Products, Integer> {
    @Query("SELECT * FROM products WHERE product_name LIKE '%:productName%' OR product_category LIKE '%:productName%';")
    List<Products> selectProducts(@Param("productName") String productName);
}
