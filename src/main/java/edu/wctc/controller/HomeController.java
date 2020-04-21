package edu.wctc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

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
                errorMsg = "Http Error Code " + httpErrorCode;
        }

        theModel.addAttribute("errorMessage", errorMsg);

        return "errors";
    }
}
