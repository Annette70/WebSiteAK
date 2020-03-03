package edu.wctc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/controller")
public class HomeController {

    @RequestMapping("/showHomePage")
    public String showHomePage(Model model){
        return "emojistore/index";
    }

    @RequestMapping("/showLoginPage")
    public String showLoginPage(Model model) {
        return "emojistore/login";
    }

    @RequestMapping("/showSearch")
    public String showSearch(Model model) {
        return "emojistore/Search3";
    }

}
