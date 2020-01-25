package com.profdev.nightclubs.nightclubsreport.controllers;

import com.profdev.nightclubs.nightclubsreport.models.NightClubs;
import com.profdev.nightclubs.nightclubsreport.service.NightClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller("/clubs")
@RequestMapping(value ="/clubs")
public class NightClubController {

    @Autowired
    NightClubService service;

    public NightClubController(NightClubService nightClubService) {
        this.service = nightClubService;
    }

    @GetMapping
    public ModelAndView getNightClubsPage(){
        return showNightClubs();
    }

    @PostMapping
    public ModelAndView showNightClubs()  {
        Map<String, List<NightClubs>> model = new HashMap<>();
        List<NightClubs> nightClubs = new ArrayList<>(service.getAllNightClubs());
        model.put("nightClubs", nightClubs);
        return new ModelAndView("nightclub", model);
    }
}
