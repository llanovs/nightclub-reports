package com.profdev.nightclubs.nightclubsreport.service;

import com.profdev.nightclubs.nightclubsreport.dao.NightClubServiceDao;
import com.profdev.nightclubs.nightclubsreport.models.NightClubs;
import com.profdev.nightclubs.nightclubsreport.repository.NightClubsRepositoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NightClubService implements NightClubServiceDao {

    @Autowired
    final NightClubsRepositoryDao repository;

    @Autowired
    public NightClubService(NightClubsRepositoryDao nightClubsRepository) {
        this.repository = nightClubsRepository;
    }

    @Override
    public boolean addNightClub(String nightClubName) {
        if(getNightClubByName(nightClubName)== null) {
            NightClubs nightClub = new NightClubs(nightClubName);
            repository.save(nightClub);
            return true;
        }
        return false;
    }

    @Override
    public List<NightClubs> getAllNightClubs() {
        return repository.findAll();
    }

    @Override
    public NightClubs getNightClubByName(String nightClubName) {
        return repository.findByNightClubName(nightClubName).orElse(null);
    }

    @Override
    public NightClubs getNightClubById(int nightClubId) {
        return repository.findById(nightClubId).orElse(null);
    }
}
