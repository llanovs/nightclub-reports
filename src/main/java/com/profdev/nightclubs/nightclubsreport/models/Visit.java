package com.profdev.nightclubs.nightclubsreport.models;

public class Visit {
    private String visitorName;
    private String nightClubName;

    public Visit(String visitorName, String nightClubName) {
        this.visitorName = visitorName;
        this.nightClubName = nightClubName;
    }

    public Visit() {
    }

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public String getNightClubName() {
        return nightClubName;
    }

    public void setNightClubName(String nightClubName) {
        this.nightClubName = nightClubName;
    }
}
