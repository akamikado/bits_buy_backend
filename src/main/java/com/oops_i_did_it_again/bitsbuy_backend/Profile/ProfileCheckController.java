package com.oops_i_did_it_again.bitsbuy_backend.Profile;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oops_i_did_it_again.bitsbuy_backend.Profile.ProfileRequest;
import com.oops_i_did_it_again.bitsbuy_backend.Profile.UpdateUserProfile;
import com.oops_i_did_it_again.bitsbuy_backend.mysqlaccess.Users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import net.minidev.json.JSONObject;

@RestController
public class ProfileCheckController {
    @Autowired 
    private UpdateUserProfile updateUserProfile;

    @PostMapping("/profile")
    @ResponseBody
    public JSONObject ProfileCheck(@RequestBody ProfileRequest profileRequest){
        System.out.println("hello");
        List<Users> userDetails = updateUserProfile.checkEmail(profileRequest.getEmail());
        JSONObject response = new JSONObject();
        if(!userDetails.isEmpty()){
            if(!userDetails.get(0).getName().isEmpty() && userDetails.get(0).getMobileNo()!= null && !userDetails.get(0).getHostel().isEmpty()){

                response.put("profileCompleted", true);
            }
            response.put("profileCompleted", false);
        } else {
            updateUserProfile.createUser(profileRequest.getEmail());
            response.put("profileCompleted", false);
        }   
        return response;
    }
}



