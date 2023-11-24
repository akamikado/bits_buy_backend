package Profile;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import Profile.UpdateUserProfile;
import mysqlaccess.Users;
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
            if(!userDetails.get(0).getName().isEmpty() && userDetails.get(0).getMobileNo()!= null){
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

class ProfileRequest{
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

