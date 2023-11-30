package com.oops_i_did_it_again.bitsbuy_backend.Profile;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oops_i_did_it_again.bitsbuy_backend.Profile.ProfileRequest;
import com.oops_i_did_it_again.bitsbuy_backend.Profile.UpdateUserProfile;
import com.oops_i_did_it_again.bitsbuy_backend.mysqlaccess.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@RestController
public class ProfileUpdateController {
    @Autowired 
    private UpdateUserProfile updateUserProfile;

    @PostMapping("/profile/update")
    @ResponseBody
    public String Update(@RequestBody ProfileRequest profileRequest) {
        updateUserProfile.updatingNameMobileNo(profileRequest.getEmail(),profileRequest.getName(), profileRequest.getPhonenum(), profileRequest.getHostel());
        return "Saved";
    }
}


