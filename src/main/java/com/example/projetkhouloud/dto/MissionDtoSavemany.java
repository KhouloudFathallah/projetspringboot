package com.example.projetkhouloud.dto;

import com.example.projetkhouloud.entities.Mission;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.util.List;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MissionDtoSavemany {
    private Long id;
    private String name;
    private String period;
    private List<Long> employeId ;


    public static MissionDtoSavemany fromentitie(Mission mission) {
        MissionDtoSavemany missiondto = new MissionDtoSavemany();
        BeanUtils.copyProperties(mission, missiondto);

        return missiondto;
    }
    public static  Mission toentitie(MissionDtoSavemany dto) {
        Mission mission = new Mission();
        BeanUtils.copyProperties(dto, mission);
        return mission;

    }
}
