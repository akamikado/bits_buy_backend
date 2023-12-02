package com.oops_i_did_it_again.bitsbuy_backend.mysqlaccess;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "products")
public class Products {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "product_id")
    private Integer product_id;

    @Column(name = "product_name")
    @NotNull
    private String product_name;

    @Column(name = "product_category")
    private String product_category;

    @Column(name = "product_description")
    private String product_description;

    @Column(name = "image")
    private String image;

    @Column(name = "owner_id")
    @NotNull
    private Integer owner_id;

    @Column(name = "create_date")
    @NotNull
    private Date create_date;

    @Column(name = "end_date")
    @NotNull
    private Date end_date;
    
    @Column(name = "bid_winner")
    private Integer bid_winner;

    @Column(name = "bid")
    @NotNull
    private Integer bid;

    @Column(name = "status")
    private Integer status;

    public Integer getProductId() {
        return product_id;
    }
    public void setProductId(Integer product_id) {
        this.product_id = product_id;
    }

    public String getProductName() {
        return product_name;
    }
    public void setProductName(String product_name) {
        this.product_name = product_name;
    }

    public String getProductCategory() {
        return product_category;
    }
    public void setProductCategory(String product_category) {
        this.product_category = product_category;
    }

    public String getProductDescription() {
        return product_description;
    }
    public void setProductDescription(String product_description) {
        this.product_description = product_description;
    }

    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }

    public Integer getOwnerId() {
        return owner_id;
    }
    public void setOwnerId(Integer owner_id) {
        this.owner_id = owner_id;
    }

    public Date getCreateDate() {
        return create_date;
    }
    public void setCreateDate(Date create_id) {
        this.create_date = create_id;
    }

    public Date getEndDate() {
        return end_date;
    }
    public void setEndDate(Date end_id) {
        this.end_date = end_id;
    }

    public Integer getBidWinner() {
        return bid_winner;
    }
    public void setBidWinner(Integer bid_winner) {
        this.bid_winner = bid_winner;
    }

    public Integer getBid() {
        return bid;
    }
    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
}
