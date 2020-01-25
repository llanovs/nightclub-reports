package com.profdev.nightclubs.nightclubsreport.controllers;

import com.profdev.nightclubs.nightclubsreport.models.Visit;
import com.profdev.nightclubs.nightclubsreport.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/visits")
public class VisitsController {

    @Autowired
    VisitService service;

    @GetMapping
    public ModelAndView getVisitorsPage(){
        return showVisits();
    }

    @PostMapping
    public ModelAndView showVisits()  {
        Map<String, List<Visit>> model = new HashMap<>();
        List<Visit> visits = new ArrayList<>(service.getAllVisits());
        model.put("visits", visits);
        return new ModelAndView("visits", model);
    }
}

