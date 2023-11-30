package com.oops_i_did_it_again.bitsbuy_backend.Profile;

public class ProfileRequest{
    private String name;
    private Integer mobileNo;
    private String email;
    private String hostel;

    public String getName() {
        return name;
    }

    public Integer getPhonenum() {
        return mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public String getHostel() {
        return hostel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhonenum(Integer mobileNo) {
        this.mobileNo = mobileNo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setHostel(String hostel) {
        this.hostel = hostel;
    }
}
