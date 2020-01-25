package com.profdev.nightclubs.nightclubsreport.dao;

import com.profdev.nightclubs.nightclubsreport.models.NightClubs;

import java.util.List;

public interface NightClubServiceDao {

    abstract boolean addNightClub(String nightClubName);

    abstract public List<NightClubs> getAllNightClubs();

    abstract NightClubs getNightClubByName(String nightClubName);

    abstract NightClubs getNightClubById(int nightClubId);
}
