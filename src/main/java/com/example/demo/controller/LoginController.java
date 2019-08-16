package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @RequestMapping("login")
    public String login(Model model){
        return "/login";
    }
    @RequestMapping("login2")
    public String login2(Model model){
        return "/login2";
    }

    @RequestMapping("clickLogin")
    public String clickLogin(Model model, @RequestParam(value="userName",defaultValue="c1") String userName){
        model.addAttribute("userName", userName);
        return "/aplyList/index";
    }
/*    @RequestMapping("clickLogin")
    public String clickLogin(Model model){

        return "login2";
    }*/
}
