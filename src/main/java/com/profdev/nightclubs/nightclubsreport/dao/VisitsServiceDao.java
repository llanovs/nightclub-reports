package com.profdev.nightclubs.nightclubsreport.dao;

import com.profdev.nightclubs.nightclubsreport.models.NightClubs;
import com.profdev.nightclubs.nightclubsreport.models.Visit;
import com.profdev.nightclubs.nightclubsreport.models.Visitors;

import java.util.List;

public interface VisitsServiceDao {
    abstract void addVisit(String visitorName, String nightClubName);

    abstract List<Visit> getAllVisits();

    abstract List<NightClubs> getVisitsByVisitor(String visitorName);

    abstract List<Visitors> getVisitorsByNightClubName(String nightClubName);
}
