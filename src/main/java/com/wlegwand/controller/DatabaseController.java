package com.wlegwand.controller;

import com.wlegwand.dao.DatabaseDAO;
import com.wlegwand.dto.DepartamentDTO;
import com.wlegwand.dto.LocalizationDTO;
import com.wlegwand.dto.TeamDTO;

import javax.json.JsonStructure;

public class DatabaseController {

    JsonStructure jsonStructure;

    public DatabaseController() {
        jsonStructure = DatabaseDAO.getInstance().getData();
    }

    public DepartamentDTO getDepartament(String name) {
        return new DepartamentDTO();
    }

    public void addDepartament(DepartamentDTO departamentDTO) {

    }

    //singleton

    //addLocalisation(string departament, string localization)
    public LocalizationDTO getLocalisation(String departament, String localisation) {
        return new LocalizationDTO();
    }

    public void addLocalisation(LocalizationDTO localization){

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

    //getTeamRelationList

    //removeTeamRelation


}
