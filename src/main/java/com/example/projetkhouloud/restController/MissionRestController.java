package com.example.projetkhouloud.restController;

import com.example.projetkhouloud.dao.EmployeeRepository;
import com.example.projetkhouloud.entities.Departement;
import com.example.projetkhouloud.entities.Employee;
import com.example.projetkhouloud.entities.Mission;
import com.example.projetkhouloud.service.MissionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor
@RequestMapping("/employee/mission")
public class MissionRestController {
    MissionService missionService;
    EmployeeRepository employeeRepository;

    @GetMapping
    public List<Mission> getAllMission(
            @RequestParam(name = "page",defaultValue = "1") int page,
            @RequestParam(name="size",defaultValue = "5")int size
            , @RequestParam(name = "mc",defaultValue = "")String mc){
        Page<Mission> listePage = missionService
                .getMissionsByMC(mc, PageRequest.of(page-1,size));
        return listePage.getContent();
    }
    @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
    public void subscribeMission(@RequestParam("mission")String mission) throws IOException {
        Mission m = new ObjectMapper().readValue(mission,Mission.class);
        missionService.saveMission(m);
    }

}

