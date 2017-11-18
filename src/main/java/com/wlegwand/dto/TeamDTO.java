package com.wlegwand.dto;

import java.util.List;

public class TeamDTO {


    private String department;
    private String localization;
    private String team;
    private List<TeamDTO> teamRelationList;

    public TeamDTO() {
    }

    public TeamDTO(String department, String localization, String team) {//, List<TeamDTO> teamRelationList
        this.department = department;
        this.localization = localization;
        this.team = team;
        //this.teamRelationList = teamRelationList;
    }


    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getLocalization() {
        return localization;
    }

    public void setLocalization(String localization) {
        this.localization = localization;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public List<TeamDTO> getTeamRelationList() {
        return teamRelationList;
    }

    public void setTeamRelationList(List<TeamDTO> teamRelationList) {
        this.teamRelationList = teamRelationList;
    }

    public void addTeamRelation(TeamDTO relatedTeam) {
        this.teamRelationList.add(relatedTeam);
    }




}
