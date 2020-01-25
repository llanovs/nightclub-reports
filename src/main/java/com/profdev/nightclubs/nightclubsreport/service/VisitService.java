package com.profdev.nightclubs.nightclubsreport.service;

import com.profdev.nightclubs.nightclubsreport.dao.VisitsServiceDao;
import com.profdev.nightclubs.nightclubsreport.models.NightClubs;
import com.profdev.nightclubs.nightclubsreport.models.Visit;
import com.profdev.nightclubs.nightclubsreport.models.Visitors;
import com.profdev.nightclubs.nightclubsreport.models.Visits;
import com.profdev.nightclubs.nightclubsreport.repository.VisitsRepositoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VisitService implements VisitsServiceDao {

    @Autowired
    NightClubService nightClubService;

    @Autowired
    VisitorsService visitorsService;

    @Autowired
    final VisitsRepositoryDao repository;

    @Autowired
    public VisitService(VisitsRepositoryDao visitsRepositoryDao) {
        this.repository = visitsRepositoryDao;
    }

    @Override
    public void addVisit(String visitorName, String nightClubName) {
        Visits visit = new Visits();
        visit.setVisitorId(visitorsService.getVisitorByName(visitorName).getVisitorId());
        visit.setNightClubId(nightClubService.getNightClubByName(nightClubName).getNightClubId());
        if(visit.getNightClubId() != 0 && visit.getVisitorId()!= 0)
        repository.save(visit);
    }

    @Override
    public List<Visit> getAllVisits() {
        List<Visits> visits = new ArrayList<>(repository.findAll());
        List <Visit> visit = new ArrayList<>();
        for (Visits v : visits){
            Visit vs = new Visit(visitorsService.findById(v.getVisitorId()).getVisitorName(),
                    nightClubService.getNightClubById(v.getNightClubId()).getNightClubName());
            visit.add(vs);
        }
        return visit;
    }

    @Override
    public List<NightClubs> getVisitsByVisitor(String visitorName) {
        return repository.getNightClubsVisitedByVisitorName(visitorName);
    }

    @Override
    public List<Visitors> getVisitorsByNightClubName(String nightClubName) {
        return repository.getVisitorsByNightClubName(nightClubName);
    }
}
