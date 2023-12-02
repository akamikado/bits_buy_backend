package com.oops_i_did_it_again.bitsbuy_backend.Sell;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oops_i_did_it_again.bitsbuy_backend.Profile.ProfileRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import com.oops_i_did_it_again.bitsbuy_backend.Sell.ProductRequest;
import com.oops_i_did_it_again.bitsbuy_backend.Sell.ProductQuery;

@RestController
public class AddProduct {
    @Autowired 
    private ProductQuery productquery;

    @PostMapping("/product/add")
    @ResponseBody
    public String Create(@RequestBody ProductRequest productrequest) {
        productquery.createProduct(productrequest.getProductName(),productrequest.getImageURL(), productrequest.getProductDescription(), productrequest.getProductCategory(),productrequest.getBasePrice() ,productrequest.getEmail());
        return "Created";
    }

}
