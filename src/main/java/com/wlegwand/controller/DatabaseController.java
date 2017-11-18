package com.wlegwand.controller;

import com.wlegwand.dao.DatabaseDAO;
import com.wlegwand.dto.DepartmentDTO;
import com.wlegwand.dto.LocalizationDTO;
import com.wlegwand.dto.TeamDTO;

import javax.json.JsonStructure;
import java.util.List;

public class DatabaseController {

    JsonStructure jsonStructure;

    public DatabaseController() {
        jsonStructure = DatabaseDAO.getInstance().getData();
    }

    public DepartmentDTO getDepartament(String name) {
        return new DepartmentDTO();
    }

    public void addDepartament(DepartmentDTO departmentDTO) {//to jest get i zwraca departament

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
    public TeamDTO getTeam(String department, String localization, String team){
        return new TeamDTO();
    }

    //removeTeam

    //addTeamRelation

    public void addAssociates(TeamDTO team, TeamDTO relatedTeam){
        team.addTeamRelation(relatedTeam);
    }

    /*public List<TeamDTO> getAssociates(String department, String localization, String team){
        return relations;
    }
    */

    //removeTeamRelation


}
