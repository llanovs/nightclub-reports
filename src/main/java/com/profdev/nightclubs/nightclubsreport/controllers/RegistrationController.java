package com.profdev.nightclubs.nightclubsreport.controllers;

import com.profdev.nightclubs.nightclubsreport.models.Visit;
import com.profdev.nightclubs.nightclubsreport.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    @Autowired
    RegistrationService service;

    @GetMapping
    public ModelAndView getRegistrationPage() {
        return new ModelAndView("registration");
    }

    @PostMapping
    public ModelAndView showNightClubs(HttpSession session, @RequestParam("registrationId") int registrationId,
                @Nullable @RequestParam("userName") String userName,@Nullable @RequestParam("nightClubName") String nightClubName) {
        Map<String, String> model = new HashMap<>();
        if (registrationId != 0) {
            if (registrationId == 1) {
                service.addNightClub(nightClubName);
            } else if (registrationId == 2) {
                service.addVisitor(userName);
            } else if (registrationId == 3) {
                service.addVisit(userName, nightClubName);
            }
        } else {
            model.put("result", "Something went wrong");
        }
        return new ModelAndView("registration", model);
    }

}
