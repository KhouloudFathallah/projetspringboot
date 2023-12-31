package com.example.projetkhouloud.restController;

import com.example.projetkhouloud.entities.Departement;
import com.example.projetkhouloud.service.IServiceDepartement;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("/departements")
public class DepartementRestController {
    private IServiceDepartement serviceDepartement;

    @GetMapping
    public List<Departement> getAllDepartements(@RequestParam(name = "page",defaultValue = "1") int page,
                                            @RequestParam(name="size",defaultValue = "5")int size
            , @RequestParam(name = "mc",defaultValue = "")String mc){
        Page<Departement> listePage = serviceDepartement.getDepartementsByMC(mc,PageRequest.of(page-1,size));

        return listePage.getContent();
    }
    @DeleteMapping(value="/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteDep(@PathVariable("id") Long id){
        serviceDepartement.deleteDepartement(id);

    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addDep(@RequestParam("departement")String departement) throws IOException {
        Departement d = new ObjectMapper().readValue(departement,Departement.class);
        serviceDepartement.saveDepartement(d);


    }
}
