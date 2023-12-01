package com.oops_i_did_it_again.bitsbuy_backend.Home;

public class ProductDTO {
    private String name;
    private int highestBid;

    public ProductDTO(String name, int highestBid) {
        this.name = name;
        this.highestBid = highestBid;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHighestBid() {
        return highestBid;
    }

    public void setHighestBid(int highestBid) {
        this.highestBid = highestBid;
    }
}
