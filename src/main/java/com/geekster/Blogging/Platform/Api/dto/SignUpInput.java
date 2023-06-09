package com.geekster.Blogging.Platform.Api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpInput {
    private String userName;
    private String userEmail;
    private String userPassword;
}
