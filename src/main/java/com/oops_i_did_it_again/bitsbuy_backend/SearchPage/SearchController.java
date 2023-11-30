package com.oops_i_did_it_again.bitsbuy_backend.SearchPage;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.oops_i_did_it_again.bitsbuy_backend.mysqlaccess.Products;
import com.oops_i_did_it_again.bitsbuy_backend.Home.HomeQuery;
import com.oops_i_did_it_again.bitsbuy_backend.mysqlaccess.Products;

import net.minidev.json.JSONObject;
import com.oops_i_did_it_again.bitsbuy_backend.Home.ProductDTO;

@RestController
public class SearchController {
    @Autowired 
    private SearchQuery searchQuery;
    
    @GetMapping("/search")
    @ResponseBody
    public JSONObject Home(@RequestParam("productName") String productName){
        List<Products> productDetails = searchQuery.selectProducts(productName);

        // Convert the list of Products to a list of ProductDTO
        List<ProductDTO> productDTOList = productDetails.stream()
                .map(product -> new ProductDTO(product.getProductName(), product.getBid()))
                .collect(Collectors.toList());

        // Create a JSON object to hold the list
        JSONObject response = new JSONObject();
        response.put("products", productDTOList);

        return response;
    }
}
