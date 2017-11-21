package com.wlegwand.dto;

import java.util.ArrayList;
import java.util.List;

public class TeamDTO {

    private Integer id;
    private String name;
    private String department;
    private String localization;
    private List<Integer> teamRelationList;

    public TeamDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.teamRelationList = new ArrayList<Integer>();
    }

    public TeamDTO(Integer id, String name, String department, String localization) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.localization = localization;
        this.teamRelationList = new ArrayList<Integer>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getTeamRelationList() {
        return teamRelationList;
    }

    public void setTeamRelationList(List<Integer> teamRelationList) {
        this.teamRelationList = teamRelationList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeamDTO teamDTO = (TeamDTO) o;

        if (!name.equals(teamDTO.name)) return false;
        if (!department.equals(teamDTO.department)) return false;
        return localization.equals(teamDTO.localization);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + department.hashCode();
        result = 31 * result + localization.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "TeamDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teamRelationList=" + teamRelationList +
                '}';
    }
}
