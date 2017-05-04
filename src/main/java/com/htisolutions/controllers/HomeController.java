package com.htisolutions.controllers;

import com.htisolutions.services.HomeService;
import com.htisolutions.viewModels.UserEntryViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {

    private HomeService homeService;

    @Autowired
    HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @RequestMapping()
    public ModelAndView index() {
        List<UserEntryViewModel> userEntries = homeService.calculateUsers();

        ModelAndView model = new ModelAndView("views/home");
        model.addObject("userEntries", userEntries);
        return model;
    }
}
