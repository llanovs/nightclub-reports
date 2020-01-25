package com.profdev.nightclubs.nightclubsreport.repository;

import com.profdev.nightclubs.nightclubsreport.models.NightClubs;
import com.profdev.nightclubs.nightclubsreport.models.Visitors;
import com.profdev.nightclubs.nightclubsreport.models.Visits;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitsRepositoryDao extends CrudRepository<Visits, Integer> {

    //JPQL query statement
    @Query(value = "select distinct v from Visits vs, Visitors v, NightClubs  n where vs.visitorId = v.visitorId " +
            " and n.nightClubId= vs.nightClubId and n.nightClubName =?1")
    List<Visitors> getVisitorsByNightClubName(String nightClubName);

    //JPQL query statement
    @Query(value = "select distinct n from Visits vs, Visitors v, NightClubs  n where vs.visitorId = v.visitorId " +
            "and n.nightClubId= vs.nightClubId and v.visitorName = ?1")
    List<NightClubs> getNightClubsVisitedByVisitorName(String visitorName);

    //JPQL query statement
    @Override
    @Query(value = "SELECT v FROM Visits v")
    List<Visits> findAll();
}
