package com.example.projetkhouloud.dto;

import com.example.projetkhouloud.entities.Mission;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class MissionDTO {

    private Long id;
    private String name;
    private String period;
    //private List<Integer> employeId ;


    public static MissionDTO fromentitie(Mission mission) {
        MissionDTO missiondto = new MissionDTO();
        BeanUtils.copyProperties(mission, missiondto);

        return missiondto;
    }
    public static  Mission toentitie(MissionDTO dto) {
        Mission mission = new Mission();
        BeanUtils.copyProperties(dto, mission);
        return mission;

    }
}
