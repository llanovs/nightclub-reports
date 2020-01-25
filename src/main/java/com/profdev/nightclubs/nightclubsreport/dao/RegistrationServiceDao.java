package com.profdev.nightclubs.nightclubsreport.dao;

public interface RegistrationServiceDao {
    abstract boolean addNightClub(String nightClubName);

    abstract boolean addVisitor(String visitorName);

    abstract void addVisit(String visitorName, String nightClubName);
}
