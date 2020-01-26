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
import java.util.List;

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
        resetReportsData(session);
        if (!data.isEmpty()) {
            session.setAttribute("dataId", reportId);
            session.setAttribute("data", data);
            if(reportId == 1){
                List<Visitors> list = service.getVisitorsByNightClubName(data);
                if(list.size() > 0)
                    session.setAttribute("visitorsNightClub", list);
                else
                    session.setAttribute("dataId", 4);
            }else if(reportId == 2){
                List<NightClubs> list = service.getVisitedNightClubs(data);
                if(list.size() > 0)
                   session.setAttribute("visitedNightClubs", list);
                else
                    session.setAttribute("dataId", 4);
            } else {
                List<NightClubs> list = service.getNotVisitedNightClubs(data);
                if(list == null)
                    session.setAttribute("dataId", 0);
                else if(list.size() > 0)
                    session.setAttribute("notVisitedNightClubs", list);
                else
                    session.setAttribute("dataId", 4);
            }
        } else {
            session.setAttribute("dataId", 0);
        }
        return new ModelAndView("reports");
    }

    private void resetReportsData(HttpSession session){
        session.setAttribute("visitorsNightClub", null);
        session.setAttribute("notVisitedNightClubs", null);
        session.setAttribute("visitedNightClubs", null);
        session.setAttribute("data", null);
    }
}
