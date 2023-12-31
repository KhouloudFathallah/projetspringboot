package com.example.projetkhouloud.controller;

import com.example.projetkhouloud.entities.Employee;
import com.example.projetkhouloud.service.IServiceDepartement;
import com.example.projetkhouloud.service.IServiceEmployee;
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

@Controller
@AllArgsConstructor
public class EmployeeController {
    IServiceEmployee serviceEmployee;
    IServiceDepartement serviceDepartement;
    @GetMapping("/user/employee")
    public String getAllEmployees(Model m , @RequestParam(name = "page",defaultValue = "1") int page,
                                 @RequestParam(name="size",defaultValue = "5")int size
            , @RequestParam(name = "mc",defaultValue = "")String mc){
        Page<Employee> listePage = serviceEmployee.getEmployeesByMC(mc, PageRequest.of(page-1,size));
        m.addAttribute("data",listePage.getContent());
        m.addAttribute("pages",new int [listePage.getTotalPages()]);
        m.addAttribute("current",listePage.getNumber());

        m.addAttribute("mc",mc);
        m.addAttribute("employees", listePage);
        return "vueEmployee";
    }
    @GetMapping("/admin/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Long id){
        serviceEmployee.deleteEmployee(id);
        return "redirect:/user/employee";
    }
    @GetMapping("/admin/formemployee")
    public String formAjout(Model m){


        m.addAttribute("departements",serviceDepartement.getAllDepartements());
        m.addAttribute("employee",new Employee());
        return "ajoutEmployee";
    }


    @PostMapping("/admin/save")
    public String saveEmployee(@Valid Employee p, BindingResult bindingResult, Model m, @RequestParam("f") MultipartFile mf) throws IOException {

        if(bindingResult.hasErrors()){
            m.addAttribute("departements",serviceDepartement.getAllDepartements());
            return "ajoutEmployee";
        }
        serviceEmployee.saveEmployee(p,mf);
        return "redirect:/user/employee";
    }
    @GetMapping("/admin/edit/{id}")
    public String editEmployee(@PathVariable Long id , Model m){
        m.addAttribute("employee", serviceEmployee.getEmployee(id));
        m.addAttribute("departements" , serviceDepartement.getAllDepartements());
        return "ajoutEmployee";
    }
    @GetMapping("/")
    public String home(){
        return "redirect:/user/employee";
    }


}
