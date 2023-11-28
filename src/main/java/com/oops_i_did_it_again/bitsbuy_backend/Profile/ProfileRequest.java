package com.oops_i_did_it_again.bitsbuy_backend.Profile;

public class ProfileRequest{
    private String name;
    private Integer phonenum;
    private String email;

    public String getName() {
        return name;
    }

    public Integer getPhonenum() {
        return phonenum;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhonenum(Integer phonenum) {
        this.phonenum = phonenum;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
