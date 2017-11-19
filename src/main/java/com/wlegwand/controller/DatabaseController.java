package com.wlegwand.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.wlegwand.dao.DatabaseDAO;
import com.wlegwand.dto.DepartmentDTO;
import com.wlegwand.dto.LocalizationDTO;
import com.wlegwand.dto.TeamDTO;

import javax.json.JsonStructure;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseController {

    JsonStructure jsonStructure;
    private static DatabaseController instance;
    private DatabaseController(){

    }
    public static DatabaseController getInstance(){
        if (instance == null) {
            instance = new DatabaseController();
        }
        return instance;
    }

    private Map<String, HashMap<String,HashMap<String,TeamDTO>>> companyStructure = new HashMap<String, HashMap<String, HashMap<String, TeamDTO>>>();

    public String addDepartmentToContainer(String department){

        boolean doesExist = false;
        if(companyStructure.containsKey(department)){
                    doesExist = true;
        }
        if(!doesExist){
            companyStructure.put(department, new HashMap<String,HashMap<String,TeamDTO>>());
            return "Department added!";
        }
        else
            return "Department already exists!";
    }

    public String addLocalizationToContainer(String department,String localization){

        boolean doesExist = false;
        if(companyStructure.containsKey(department)){
            if(companyStructure.get(department).containsKey(localization)) {
                    doesExist = true;
            }
        }
        if(!doesExist){
            companyStructure.put(department, new HashMap<String,HashMap<String,TeamDTO>>());
            companyStructure.get(department).put(localization, new HashMap<String,TeamDTO>());
            return "Localization added!";
        }
        else
            return "Localization already exists!";
    }

    public String addTeamToContainer(String department,String localization,String team){

        boolean doesExist = false;
        if(companyStructure.containsKey(department)){
            if(companyStructure.get(department).containsKey(localization)) {
                if (companyStructure.get(department).get(localization).containsKey(team)) {
                    doesExist = true;
                }
            }
        }
        if(!doesExist){
            companyStructure.put(department, new HashMap<String,HashMap<String,TeamDTO>>());
            companyStructure.get(department).put(localization, new HashMap<String,TeamDTO>());
            companyStructure.get(department).get(localization).put(team, new TeamDTO(department,localization,team));
            return "Team added!";
        }
        else
            return "Team already exists!";
    }

    public List<TeamDTO> getAssociates(String department,String localization,String team){
        if(companyStructure.containsKey(department)) {
            if (companyStructure.get(department).containsKey(localization)) {
                if (companyStructure.get(department).get(localization).containsKey(team)) {
                    return companyStructure.get(department).get(localization).get(team).getTeamRelationList();
                }
            }
        }
        return  null;
    }

    public void endTree(){
        companyStructure.clear();
    }








}
