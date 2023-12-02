package com.oops_i_did_it_again.bitsbuy_backend.Sell;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.*;
import com.oops_i_did_it_again.bitsbuy_backend.mysqlaccess.Products;

public interface ProductQuery extends CrudRepository<Products, Integer> {
    @Modifying
    @Query("INSERT INTO products (product_name,product_category,product_description,image,bid,owner_id) SELECT :productName,:productCategory,:productDescription,:imageUrl,:basePrice,user_id FROM users WHERE email=:email")
    void createProduct(@Param("productName") String productName, @Param("imageUrl") String imageUrl, @Param("productDescription") String productDescription, @Param("productCategory") String productCategory,@Param("basePrice") Integer basePrice, @Param("email") String email);
}
