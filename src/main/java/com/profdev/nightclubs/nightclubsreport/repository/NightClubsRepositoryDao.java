package com.profdev.nightclubs.nightclubsreport.repository;

import com.profdev.nightclubs.nightclubsreport.models.NightClubs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NightClubsRepositoryDao extends JpaRepository<NightClubs, Integer> {

    //JPQL query statement
    @Query(value = "SELECT n FROM NightClubs n WHERE n.nightClubId = ?1")
    Optional<NightClubs> findById(Integer nightClubId);

    //JPQL query statement
    @Query(value = "SELECT n FROM NightClubs n WHERE n.nightClubName = ?1")
    Optional<NightClubs> findByNightClubName(String nightClubName);

    //JPQL query statement
    @Override
    @Query(value = "SELECT n FROM NightClubs n")
    List<NightClubs> findAll();
}
