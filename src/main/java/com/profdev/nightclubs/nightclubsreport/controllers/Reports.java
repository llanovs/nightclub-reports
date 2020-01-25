package com.profdev.nightclubs.nightclubsreport.controllers;

import com.profdev.nightclubs.nightclubsreport.models.NightClubs;
import com.profdev.nightclubs.nightclubsreport.models.Visitors;
import com.profdev.nightclubs.nightclubsreport.service.ReportsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/reports")
public class Reports{
    @Autowired
    ReportsService service;

    @GetMapping
    public ModelAndView getReportPage() {
        return new ModelAndView("reportsForm");
    }

    @PostMapping
    public ModelAndView createReport(HttpSession session, @Nullable @RequestParam("reportId") int reportId,
                               @RequestParam("data") String data) {
        if (reportId != 0) {
            resetReportsData(session);
            session.setAttribute("dataId", reportId);
            session.setAttribute("data", data);
            if(reportId == 1){
                session.setAttribute("visitorsNightClub", service.getVisitorsByNightClubName(data));
            }else if(reportId == 2){
                session.setAttribute("visitedNightClubs", service.getVisitedNightClubs(data));
            } else {
                session.setAttribute("notVisitedNightClubs", service.getNotVisitedNightClubs(data));
            }
        }
        return new ModelAndView("reports");
    }

    private void resetReportsData(HttpSession session){
        session.setAttribute("visitorsNightClub", null);
        session.setAttribute("notVisitedNightClubs", null);
        session.setAttribute("visitedNightClubs", null);
        session.setAttribute("dataId", null);
        session.setAttribute("data", null);
    }
}
