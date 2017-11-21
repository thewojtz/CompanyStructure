package com.wlegwand.controller;

import com.wlegwand.dao.DatabaseDAO;
import com.wlegwand.dto.CompanyDTO;
import com.wlegwand.dto.TeamDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.json.JsonStructure;
import java.util.HashMap;
import java.util.List;

public class DatabaseController {

    private static final Logger LOG = LogManager.getLogger(DatabaseController.class);

    JsonStructure jsonStructure;
    private CompanyDTO companyDTO;
    private DatabaseDAO databaseDAO;
    private static DatabaseController instance;


    private DatabaseController(){
        databaseDAO = DatabaseDAO.getInstance();
        companyDTO = new CompanyDTO(databaseDAO.getData());

    }
    public static DatabaseController getInstance(){
        if (instance == null) {
            instance = new DatabaseController();
        }
        return instance;
    }


    public String addDepartment(String department){
        try {
            companyDTO.addDepartment(department);
            return "Department added";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String addLocalization(String department, String localization){
        try {
            companyDTO.addLocalization(department, localization);
            return "Localization added";
        } catch (Exception e) {
            return e.getMessage();
        }

    }

    public String addTeam(String department, String localization, String team){
        try {
            companyDTO.addTeam(department, localization, team);
            return "Team added";
        } catch (Exception e) {
            return e.getMessage();
        }

    }

    public List<TeamDTO> getAssociates(String department, String localization, String team){
        return  companyDTO.getTeamAssociates(department,localization,team);
    }

    public void endTree(){
        companyDTO.clearData();
    }








}
