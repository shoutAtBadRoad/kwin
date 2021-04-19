package com.kwin.db.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TransfController {

    @GetMapping("main")
    public String enterBack(){
        return "dashboard";
    }

    @GetMapping("test")
    public String test(){return "test";}

    @GetMapping("login")
    public String login(){return "login";}

    @GetMapping("dash")
    public String manage() {
        return "dashboard";
    }


}
