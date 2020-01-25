package com.profdev.nightclubs.nightclubsreport.service;

import com.profdev.nightclubs.nightclubsreport.dao.VisitorsServicedAO;
import com.profdev.nightclubs.nightclubsreport.models.Visitors;
import com.profdev.nightclubs.nightclubsreport.repository.VisitorsRepositoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitorsService implements VisitorsServicedAO {

    @Autowired
    final VisitorsRepositoryDao repository;

    @Autowired
    public VisitorsService(VisitorsRepositoryDao visitorsRepositoryDao) {
        this.repository = visitorsRepositoryDao;
    }

    @Override
    public boolean addVisitor(String visitorName) {
        if(getVisitorByName(visitorName)== null) {
            Visitors visitor = new Visitors();
            visitor.setVisitorName(visitorName);
            repository.save(visitor);
            return true;
        }
        return false;
    }

    @Override
    public List<Visitors> getAllVisitors() {
        return repository.findAll();
    }

    @Override
    public Visitors getVisitorByName(String visitorName) {
        return repository.findByVisitorName(visitorName).orElse(null);
    }

    @Override
    public Visitors findById(int visitorId) {
        return repository.findById(visitorId).orElse(null);
    }
}
