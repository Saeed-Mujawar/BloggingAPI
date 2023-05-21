package com.geekster.Blogging.Platform.Api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignInInput {
    private String userEmail;
    private String userPassword;
}
