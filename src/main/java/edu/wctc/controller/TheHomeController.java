package edu.wctc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TheHomeController {

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

    @RequestMapping(path = "/errors")
    public String showErrorPage(HttpServletRequest request, Model theModel) {
        int httpErrorCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        String errorMsg;

        switch (httpErrorCode) {
            case 400:
                errorMsg = "Http Error Code 400: Bad request";
                break;
            case 401:
                errorMsg = "Http Error Code 401: Unauthorized";
                break;
            case 404:
                errorMsg = "Http Error Code 404: Resource not found";
                break;
            case 500:
                errorMsg = "Http Error Code 500: Internal server error";
                break;
            default:
                errorMsg = "Something went wrong";
        }

        theModel.addAttribute("errorMessage", errorMsg);

        return "errors";
    }
}