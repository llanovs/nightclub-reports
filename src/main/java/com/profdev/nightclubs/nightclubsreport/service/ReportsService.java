package com.profdev.nightclubs.nightclubsreport.service;


import com.profdev.nightclubs.nightclubsreport.dao.ReportsServiceDao;
import com.profdev.nightclubs.nightclubsreport.models.NightClubs;
import com.profdev.nightclubs.nightclubsreport.models.Visitors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReportsService implements ReportsServiceDao {

    @Autowired
    NightClubService nightClubService;

    @Autowired
    VisitorsService visitorsService;

    @Autowired
    VisitService visitService;


    @Override
    public List<Visitors> getVisitorsByNightClubName(String nightClubName) {
        return visitService.getVisitorsByNightClubName(nightClubName);
    }

    @Override
    public List<NightClubs> getVisitedNightClubs(String visitorName) {
        return visitService.getVisitsByVisitor(visitorName);
    }

    @Override
    public List<NightClubs> getNotVisitedNightClubs(String visitorName) {
        List<NightClubs> allNightClubs = nightClubService.getAllNightClubs();
        List<NightClubs> visited = getVisitedNightClubs(visitorName);
        List<NightClubs> notVisited = new ArrayList<>();
        for (NightClubs nightClub : allNightClubs) {
            if (!visited.contains(nightClub))
                notVisited.add(nightClub);
        }
        return notVisited;
    }
}
