package com.wlegwand.dto;

import java.util.List;

public class DepartmentDTO {

    private String name;
    private List<LocalizationDTO> localizationDTOList;

    public DepartmentDTO(){

    }

    public DepartmentDTO(String name, List<LocalizationDTO> localizationDTOList) {
        this.name = name;
        this.localizationDTOList = localizationDTOList;
    }
}
