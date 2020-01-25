package com.profdev.nightclubs.nightclubsreport.repository;

import com.profdev.nightclubs.nightclubsreport.models.Visitors;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VisitorsRepositoryDao extends CrudRepository<Visitors, Integer> {

    //JPQL query statement
    @Query(value = "SELECT v FROM Visitors v WHERE v.visitorId = ?1")
    Optional<Visitors> findById(int visitorId);

    //JPQL query statement
    @Query(value = "SELECT v FROM Visitors v WHERE v.visitorName= ?1")
    Optional<Visitors> findByVisitorName(String visitorName);

    //JPQL query statement
    @Override
    @Query(value = "SELECT v FROM Visitors v")
    List<Visitors> findAll();
}