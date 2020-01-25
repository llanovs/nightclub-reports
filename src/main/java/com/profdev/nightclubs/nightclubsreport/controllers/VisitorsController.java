package com.profdev.nightclubs.nightclubsreport.controllers;

import com.profdev.nightclubs.nightclubsreport.models.Visitors;
import com.profdev.nightclubs.nightclubsreport.service.VisitorsService;
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
@RequestMapping(value = "/visitors")
public class VisitorsController {

    @Autowired
    VisitorsService service;

    @GetMapping
    public ModelAndView getVisitorsPage(){
        return showVisitors();
    }

    @PostMapping
    public ModelAndView showVisitors()  {
        Map<String, List<Visitors>> model = new HashMap<>();
        List<Visitors> visitors = new ArrayList<>(service.getAllVisitors());
        model.put("visitors", visitors);
        return new ModelAndView("visitors", model);
    }
}
