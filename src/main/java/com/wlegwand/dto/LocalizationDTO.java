package com.wlegwand.dto;

import java.util.List;

public class LocalizationDTO {

    private String name;
    private List<TeamDTO> teamDTOList;

    public LocalizationDTO(){

    }

    public LocalizationDTO(String name, List<TeamDTO> teamDTOList) {
        this.name = name;
        this.teamDTOList = teamDTOList;
    }
}
