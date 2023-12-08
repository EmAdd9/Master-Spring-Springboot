package com.emadd9.springboot.demoapplication.businesslogic;

import org.springframework.stereotype.Service;

@Service
public class LoginAuthenticationService {

    public boolean authenticate(String name,String password){
        boolean isValidName = name.equalsIgnoreCase("emadd9");
        boolean isValidPassword = password.equalsIgnoreCase("1234");
        return isValidPassword && isValidName;
    }
}
