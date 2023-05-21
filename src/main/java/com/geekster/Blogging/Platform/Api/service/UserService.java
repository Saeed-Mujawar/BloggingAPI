package com.geekster.Blogging.Platform.Api.service;

import com.geekster.Blogging.Platform.Api.Repository.IUserRepo;
import com.geekster.Blogging.Platform.Api.dto.SignInInput;
import com.geekster.Blogging.Platform.Api.dto.SignInOutput;
import com.geekster.Blogging.Platform.Api.dto.SignUpOutput;
import com.geekster.Blogging.Platform.Api.model.AuthenticationToken;
import com.geekster.Blogging.Platform.Api.model.User;
import jakarta.xml.bind.DatatypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class UserService {
    @Autowired
    IUserRepo userRepo;

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    FollowingService followingService;

    @Autowired
    FollowerService followerService;

    public SignUpOutput signup(User signupdto) {
        User user= userRepo.findFirstByUserEmail(signupdto.getUserEmail());
        if(user!=null){
            throw new IllegalStateException("User already exist..Sign in instead..!");
        }
        String encryptedpassword=null;
        try {
            encryptedpassword=encryptedpassword(signupdto.getUserPassword());
        }catch (Exception e){
            e.printStackTrace();
        }
        signupdto.setUserPassword(encryptedpassword);
        userRepo.save(signupdto);
        return new SignUpOutput("User created","Signed up successfully..!");

    }

    private String encryptedpassword(String userPassword) throws NoSuchAlgorithmException {
        MessageDigest md5= MessageDigest.getInstance("MD5");
        md5.update(userPassword.getBytes());
        byte[] digested=md5.digest();
        String hash= DatatypeConverter.printHexBinary(digested);
        return hash;
    }

    public SignInOutput signin(SignInInput signindto) {
        User user= userRepo.findFirstByUserEmail(signindto.getUserEmail());
        if(user==null){
            throw new IllegalStateException("Invalid user..Sign up instead..");
        }
        String encryptedpassword=null;
        try {
            encryptedpassword=encryptedpassword(signindto.getUserPassword());
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        boolean isvalid=encryptedpassword.equals(user.getUserPassword());
        if(!isvalid){
            throw new IllegalStateException("signup instead..!");
        }
        AuthenticationToken token=new AuthenticationToken(user);
        //generating token and save it
        authenticationService.savetoken(token);
        AuthenticationToken auth= authenticationService.gettoken(user);
        return new SignInOutput("User Signed in successfully",auth.getToken());
    }

    public String follow(Long myid, Long otherid) {
        if(myid==otherid){
            return "Cannot follow yourself";
        }
        User myuser= userRepo.findByUserId(myid);
        User otheruser= userRepo.findByUserId(otherid);

        if(myuser!=null && otheruser!=null){
            followingService.savefollowing(myuser,otheruser);
            followerService.saveFollower(myuser,otheruser);
            return "Followed successfully";
        }else{
            return "User invalid...!";
        }
    }
}
