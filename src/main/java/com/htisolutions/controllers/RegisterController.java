package com.htisolutions.controllers;

import com.htisolutions.services.HomeService;
import com.htisolutions.services.RegisterService;
import com.htisolutions.viewModels.RegisterViewModel;
import com.htisolutions.viewModels.UserEntryViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private RegisterService registerService;

    @Autowired
    RegisterController (RegisterService registerService) { this.registerService = registerService; }

    @RequestMapping()
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("views/register");
        RegisterViewModel registerViewModel = new RegisterViewModel();
        modelAndView.addObject("registerViewModel", registerViewModel);
        return modelAndView;
    }

    @RequestMapping(method= RequestMethod.POST)
    public String register(@ModelAttribute(value="registerViewModel") RegisterViewModel registerViewModel) {

        String firstName = registerViewModel.getFirstName();
        String lastName = registerViewModel.getLastName();
        String registerNickname = registerViewModel.getRegisterNickname();
        String registerPassword = registerViewModel.getRegisterPassword();
        String confirmPassword = registerViewModel.getConfirmPassword();

        if (registerService.validRegister(firstName, lastName, registerNickname, registerPassword, confirmPassword)) {
            return ("redirect:/home");
        } else {
            return ("redirect:/register?error");
        }
    }
}
