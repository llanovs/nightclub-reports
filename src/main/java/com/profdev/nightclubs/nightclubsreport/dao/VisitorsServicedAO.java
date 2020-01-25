package com.profdev.nightclubs.nightclubsreport.dao;

import com.profdev.nightclubs.nightclubsreport.models.Visitors;

import java.util.List;

public interface VisitorsServicedAO {
    abstract boolean addVisitor(String visitorName);

    abstract List<Visitors> getAllVisitors();

    abstract Visitors getVisitorByName(String visitorName);

    abstract public Visitors findById(int visitorId);
}
