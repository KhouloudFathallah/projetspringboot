package com.example.projetkhouloud.service;

import com.example.projetkhouloud.dao.EmployeeRepository;
import com.example.projetkhouloud.dao.MissionRepository;
import com.example.projetkhouloud.dto.MissionDTO;
import com.example.projetkhouloud.dto.MissionDtoSavemany;
import com.example.projetkhouloud.entities.Employee;
import com.example.projetkhouloud.entities.Mission;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GestionServiceMission implements MissionService {
    private MissionRepository missionRepository ;
    private EmployeeRepository employeeRepository;

    @Override
    public void saveMission(Mission m) {
        missionRepository.save(m);
    }

    @Override
    public List<Mission> getAllMissions() {
        return missionRepository.findAll();
    }

    @Override
    public Page<Mission> getMissionsByMC(String mc, Pageable p) {
        return missionRepository.findByNameContains(mc,p);
    }

    @Override
    public void deleteMission(Long id) {
        missionRepository.deleteById(id);

    }

    @Override
    public Mission getMission(Long id) {
        return missionRepository.findById(id).orElse(null);
    }
}
