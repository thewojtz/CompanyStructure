package com.wlegwand.dto;

import java.util.ArrayList;
import java.util.List;

public class LocalizationDTO {

    private String name;
    private List<Integer> teamDTOList;

    public LocalizationDTO(){

    }

    public LocalizationDTO(String name) {
        this.name = name;
        this.teamDTOList = new ArrayList<>();
    }

    public LocalizationDTO(String name, List<Integer> teamDTOList) {
        this.name = name;
        this.teamDTOList = teamDTOList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getTeamDTOList() {
        return teamDTOList;
    }

    public void setTeamDTOList(List<Integer> teamDTOList) {
        this.teamDTOList = teamDTOList;
    }

    @Override
    public String toString() {
        return "LocalizationDTO{" +
                "name='" + name + '\'' +
                ", teamDTOList=" + teamDTOList +
                '}';
    }
}
