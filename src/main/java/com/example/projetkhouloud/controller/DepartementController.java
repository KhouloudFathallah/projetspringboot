package com.example.projetkhouloud.controller;

import com.example.projetkhouloud.entities.Departement;
import com.example.projetkhouloud.service.IServiceDepartement;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class DepartementController {
    IServiceDepartement serviceDepartement;

    @GetMapping("/user/departement")
    public String getAllDepartement(Model m,@RequestParam(name = "page",defaultValue = "1") int page,
                                    @RequestParam(name="size",defaultValue = "5")int size,
                                    @RequestParam(name="mc",defaultValue = "") String mc){
        Page <Departement> liste = serviceDepartement.getDepartementsByMC(mc,PageRequest.of(page-1,size));
        m.addAttribute("data",liste.getContent());
        m.addAttribute("pages",new int [liste.getTotalPages()]);
        m.addAttribute("current",liste.getNumber());
        m.addAttribute("mc",mc) ;
        m.addAttribute("departement",liste);
        return "vuedepartement";
    }

    @GetMapping("/admin/deleteDep/{id}")
    public String deleteDepartement(@PathVariable("id") Long id){
        serviceDepartement.deleteDepartement(id);
        return "redirect:/user/departement";
    }

    @GetMapping("/admin/formdepartement")
    public String formAjouter(Model m){
        m.addAttribute("departement",new Departement());
        return "ajoutDepartement";
    }

    @GetMapping("/admin/add")
    public String saveDepartement(@ModelAttribute Departement d, Model m)
    {
        serviceDepartement.saveDepartement(d);
        return "redirect:/user/departement";
    }
    @GetMapping("/admin/editdepartement/{id}")
    public String editDepartement(@PathVariable("id") Long id,Model m){

        m.addAttribute("departement",serviceDepartement.getDepartement(id));

        return "ajoutDepartement";
    }

}
