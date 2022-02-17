package com.ilkerguldali.boredapp.controller;

import com.ilkerguldali.boredapp.service.ActivityService;
import com.ilkerguldali.boredapp.service.BoredService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ActivityController {

    @Autowired
    ActivityService activityService;
    @Autowired
    BoredService boredService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showActivities(Model model) {
        model.addAttribute("activities", activityService.getAllActivity());
        return "index";
    }


    @RequestMapping(value = "/addActivity", method = RequestMethod.POST)
    public String addActivity() {
        var newRandomActivity = boredService.getActivity();
        if(newRandomActivity != null)
            activityService.addActivity(newRandomActivity);
        return "redirect:/";
    }
}
