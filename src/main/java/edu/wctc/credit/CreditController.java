package edu.wctc.credit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/credit")
public class CreditController {

    @RequestMapping("/showForm")
    public String showForm(Model model){
        Credit theCredit = new Credit();

        model.addAttribute("bindingCredit", theCredit);

        return "credit/form";
    }

    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("bindingCredit") Credit bindingCredit){
        return "credit/display";
    }
}
