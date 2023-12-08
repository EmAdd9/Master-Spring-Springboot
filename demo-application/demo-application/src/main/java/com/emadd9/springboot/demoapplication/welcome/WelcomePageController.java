package com.emadd9.springboot.demoapplication.welcome;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WelcomePageController {


    //private Logger logger = LoggerFactory.getLogger(getClass());

    // /welcome?name=Shreya&title=Mandal
    @RequestMapping("welcome")
    public String goToWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap modelMap){
        modelMap.put("name",name);
        modelMap.put("password",password);
        return "welcome";
    }
}
