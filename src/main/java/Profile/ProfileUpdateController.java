package Profile;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import Profile.UpdateUserProfile;
import mysqlaccess.Users;

@RestController
public class ProfileUpdateController {
    @Autowired 
    private UpdateUserProfile updateUserProfile;

    @PostMapping("/profile/update")
    @ResponseBody
    public String Update(@RequestBody ProfileRequest profileRequest) {
        updateUserProfile.updatingNameMobileNo(profileRequest.getEmail(),profileRequest.getName(), profileRequest.getPhonenum());
        return "Saved";
    }
}

class ProfileRequest{
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
