package com.profdev.nightclubs.nightclubsreport.dao;

import com.profdev.nightclubs.nightclubsreport.models.NightClubs;
import com.profdev.nightclubs.nightclubsreport.models.Visitors;

import java.util.List;

public interface ReportsServiceDao {

    public abstract List<Visitors> getVisitorsByNightClubName(String nightClubName);

    public  abstract List<NightClubs> getVisitedNightClubs(String visitorName);

    public  abstract List<NightClubs> getNotVisitedNightClubs(String visitorName);

}
