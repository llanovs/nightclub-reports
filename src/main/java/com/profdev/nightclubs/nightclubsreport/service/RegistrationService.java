package com.profdev.nightclubs.nightclubsreport.service;

import com.profdev.nightclubs.nightclubsreport.dao.RegistrationServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService implements RegistrationServiceDao {
    @Autowired
    NightClubService nightClubService;

    @Autowired
    VisitorsService visitorsService;

    @Autowired
    VisitService visitService;

    public RegistrationService() {
    }

    @Override
    public boolean addNightClub(String nightClubName) {
        return nightClubService.addNightClub(nightClubName);
    }

    @Override
    public boolean addVisitor(String visitorName) {
        return visitorsService.addVisitor(visitorName);
    }

    @Override
    public void addVisit(String visitorName, String nightClubName) {
        visitService.addVisit(visitorName,nightClubName);
    }
}
