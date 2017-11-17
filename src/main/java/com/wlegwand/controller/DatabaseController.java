package com.wlegwand.controller;

import com.wlegwand.dao.DatabaseDAO;
import com.wlegwand.dto.DepartmentDTO;
import com.wlegwand.dto.LocalizationDTO;
import com.wlegwand.dto.TeamDTO;

import javax.json.JsonStructure;

public class DatabaseController {

    JsonStructure jsonStructure;

    public DatabaseController() {
        jsonStructure = DatabaseDAO.getInstance().getData();
    }

    public DepartmentDTO getDepartament(String name) {
        return new DepartmentDTO();
    }

    public void addDepartament(DepartmentDTO departmentDTO) {

    }

    //singleton

    //addLocalisation(string department, string localization)
    public LocalizationDTO getLocalization(String department, String localization) {
        return new LocalizationDTO();
    }

    public void addLocalization(LocalizationDTO localization){

    }

    //removeLocal

    //addTeam
    public void addTeam(TeamDTO teamDTO){

    }

    //getTeam
    public TeamDTO getTeam(String departament, String localisation, String team){
        return new TeamDTO();
    }

    //removeTeam

    //addTeamRelation

    public void addTeamRelation(TeamDTO team, TeamDTO relatedTeam){
        team.addTeamRelation(relatedTeam);
    }

    //getTeamRelationList


    //removeTeamRelation


}
