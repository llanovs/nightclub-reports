package com.profdev.nightclubs.nightclubsreport.dao;

public interface Visit {

    public abstract  void setNightClubId(int nightClubName);

    public abstract void setVisitorId(int visitorName);

    public abstract int getNightClubId();

    public abstract int getVisitorId();
}
