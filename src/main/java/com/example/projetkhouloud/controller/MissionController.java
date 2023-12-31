package com.example.projetkhouloud.controller;

import com.example.projetkhouloud.dao.EmployeeRepository;
import com.example.projetkhouloud.dao.MissionRepository;
import com.example.projetkhouloud.dto.MissionDTO;
import com.example.projetkhouloud.entities.Employee;
import com.example.projetkhouloud.entities.Mission;
import com.example.projetkhouloud.service.MissionService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@AllArgsConstructor
@Controller
public class MissionController {
    private MissionService missionService;
    private EmployeeRepository employeeRepository;
    private MissionRepository missionRepository;

    @GetMapping("/user/missions")
    public String getAllMissions(Model m , @RequestParam(name = "page",defaultValue = "1") int page,
                                  @RequestParam(name="size",defaultValue = "5")int size
            , @RequestParam(name = "mc",defaultValue = "")String mc){
        Page<Mission> listePage = missionService.getMissionsByMC(mc, PageRequest.of(page-1,size));
        m.addAttribute("data",listePage.getContent());
        m.addAttribute("pages",new int [listePage.getTotalPages()]);
        m.addAttribute("current",listePage.getNumber());

        m.addAttribute("mc",mc);
        m.addAttribute("missions", listePage);
        return "vueMission";
    }
    @GetMapping("/admin/deletemission/{id}")
    public String deleteMission(@PathVariable("id") Long id){
        missionService.deleteMission(id);
        return "redirect:/user/missions";
    }

    @GetMapping("/admin/formmission")
    public String formAjoutmission(Model m){

        m.addAttribute("missions",missionService.getAllMissions());
        m.addAttribute("mission",new Mission());
        return "ajoutMission";
    }

    @PostMapping("/admin/savemission")
    public String saveMission(@Valid Mission mi, Model m) {


        missionService.saveMission(mi);
        return "redirect:/user/missions";
    }

    @GetMapping("/admin/editmission/{id}")
    public String editMission(@PathVariable Long id , Model m){
        m.addAttribute("mission", missionService.getMission(id));

        return "ajoutMission";
    }


}
