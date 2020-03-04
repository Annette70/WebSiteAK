package edu.wctc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String showHome(Model model){
        return "index";
    }

    @RequestMapping("/showLogin")
    public String showLogin(Model model) {
        return "login";
    }

    @RequestMapping("/showSearch")
    public String showSearch(Model model) {
        return "Search3";
    }

}
