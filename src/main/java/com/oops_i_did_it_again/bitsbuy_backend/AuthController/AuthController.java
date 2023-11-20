package com.oops_i_did_it_again.bitsbuy_backend.AuthController;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Collections;

@RestController
public class AuthController {

    @Value("${google.client-id}") 
    private String clientId;    

    @PostMapping("/auth")
    @ResponseBody
    public String verifyTokenString (@RequestBody TokenRequest tokenRequest){
        System.out.println(clientId);
        String access_token = tokenRequest.getAccess_token();
        // Initialize the Google API client libraries.
        HttpTransport httpTransport = new NetHttpTransport();
        GsonFactory gsonFactory= new GsonFactory();
        System.out.println(1);
        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(httpTransport,gsonFactory).setAudience(Collections.singletonList(clientId)).build();
        System.out.println(2);
        if (access_token == null || access_token.isEmpty()) {
            return "Token is null or empty.";
        }
        System.out.println(3);
        try{
            GoogleIdToken token = verifier.verify(access_token);
            System.out.println(4);
            if (token != null) {
                return "Token is valid.";
            } else {
                return "Token is not valid.";
            }
        } catch (GeneralSecurityException | IOException e){
            e.printStackTrace();
            return "Token verification failed.";
        }
    }    
}

class TokenRequest {
    private String access_token;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }
}
