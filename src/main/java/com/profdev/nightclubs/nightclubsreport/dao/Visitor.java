package com.profdev.nightclubs.nightclubsreport.dao;

public interface Visitor {

    public abstract String getVisitorName();

    public abstract int getVisitorId();

    public abstract void setVisitorName(String userName);

}
