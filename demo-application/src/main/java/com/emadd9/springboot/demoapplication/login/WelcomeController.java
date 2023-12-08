package com.emadd9.springboot.demoapplication.login;


import com.emadd9.springboot.demoapplication.businesslogic.LoginAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {
    @Autowired
    private LoginAuthenticationService service;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String goToWelcomePage(ModelMap modelMap){
        modelMap.put("name",getLoggedInUsername());
        return "welcome";
    }
    private  String getLoggedInUsername(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
    /*@RequestMapping(value = "login",method = RequestMethod.POST)
    public String goToWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap modelMap){
        modelMap.put("name",name);
        modelMap.put("password",password);
        if(service.authenticate(name,password)){
            return "welcome";
        }
        else{
            modelMap.put("errorMessage","Invalid Credentials. Login Again!");
            return "login";
        }

    }*/
}
