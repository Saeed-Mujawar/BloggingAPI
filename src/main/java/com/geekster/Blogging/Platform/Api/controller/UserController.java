package com.geekster.Blogging.Platform.Api.controller;

import com.geekster.Blogging.Platform.Api.dto.SignInInput;
import com.geekster.Blogging.Platform.Api.dto.SignInOutput;
import com.geekster.Blogging.Platform.Api.dto.SignUpOutput;
import com.geekster.Blogging.Platform.Api.model.User;
import com.geekster.Blogging.Platform.Api.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/signup")
    public SignUpOutput signup(@Valid @RequestBody User signupdto){
        return userService.signup(signupdto);
    }

    @PostMapping(value = "/signin")
    public SignInOutput signin(@Valid @RequestBody SignInInput signindto){
        return userService.signin(signindto);
    }

    @PostMapping(value = "/follow/{myid}/{otherid}")
    public String follow(@Valid @PathVariable Long myid,@PathVariable Long otherid){
        return userService.follow(myid,otherid);
    }
}
