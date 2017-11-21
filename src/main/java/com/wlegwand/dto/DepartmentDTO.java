package com.wlegwand.dto;

import java.util.HashMap;
import java.util.Map;

public class DepartmentDTO {

    private String name;
    private Map<String, LocalizationDTO> localizationsMap;

    public DepartmentDTO(){

    }

    public DepartmentDTO(String name) {
        this.name = name;
        this.localizationsMap = new HashMap<>();
    }

    public DepartmentDTO(String name, Map<String, LocalizationDTO> localizationsMap) {
        this.name = name;
        this.localizationsMap = localizationsMap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, LocalizationDTO> getLocalizationsMap() {
        return localizationsMap;
    }

    public void setLocalizationsMap(Map<String, LocalizationDTO> localizationsMap) {
        this.localizationsMap = localizationsMap;
    }

    @Override
    public String toString() {
        return "DepartmentDTO{" +
                "name='" + name + '\'' +
                ", localizationsMap=" + localizationsMap +
                '}';
    }
}
