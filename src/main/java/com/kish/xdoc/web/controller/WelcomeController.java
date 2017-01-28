package com.kish.xdoc.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ThejKishore on 1/19/2017.
 */
@Controller
public class WelcomeController {

    @Value("${welcome.message:test}")
    private String message = "Hello";


    @RequestMapping("/contactUI")
    public String welcome(Map<String, Object> model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username
        String authority = Arrays.toString(auth.getAuthorities().toArray()); //get logged in username

        if(name == null || !name.isEmpty()){
            this.message =  name;
        } else {
            this.message = "default message from Properties "+this.message;
        }
        model.put("message", this.message);
        model.put("authorities", authority);
        return "welcome";
    }


    @Autowired
    private Environment environment;

    @RequestMapping("/property")
    public String query(@RequestParam("q") String q) {
        return environment.getProperty(q);
    }
}
