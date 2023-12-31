package com.example.projetkhouloud.service;

import com.example.projetkhouloud.dto.MissionDTO;
import com.example.projetkhouloud.dto.MissionDtoSavemany;
import com.example.projetkhouloud.entities.Employee;
import com.example.projetkhouloud.entities.Mission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface MissionService {
    public void saveMission(Mission m) ;
    public List<Mission> getAllMissions();

    public Page<Mission> getMissionsByMC(String mc, Pageable p);
    public void deleteMission(Long id);
    public Mission getMission(Long id);
}
