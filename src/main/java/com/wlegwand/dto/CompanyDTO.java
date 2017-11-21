package com.wlegwand.dto;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wlegwand.controller.DatabaseController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.json.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class CompanyDTO {

    private static final Logger LOG = LogManager.getLogger(CompanyDTO.class);

    private String name;
    private Map<String, DepartmentDTO> departmentsMap;
    private Map<Integer, TeamDTO> teamsMap;

    public CompanyDTO(JsonObject jsonObject) {
        JsonObject companyRoot = jsonObject.getJsonObject("company");
        this.name = companyRoot.getString("name");
        this.teamsMap = new HashMap<>();
        /* create teams data */
        for (JsonValue value : companyRoot.getJsonArray("teams")) {
            JsonObject teamObject = (JsonObject) value;
            Integer teamId = teamObject.getInt("id");
            String teamName = teamObject.getString("name");
            String department = teamObject.getString("department");
            String localization = teamObject.getString("localization");
            teamsMap.put(teamId, new TeamDTO(teamId, teamName, department, localization));
        }
        /* create teams relations */
        for (JsonValue value : companyRoot.getJsonArray("teams")) {
            JsonObject teamObject = (JsonObject) value;
            Integer teamId = teamObject.getInt("id");
            List<Integer> relationsList = new ArrayList<>();
            for (JsonValue value1 : teamObject.getJsonArray("relations")) {
                for(int i=0; i<teamsMap.get(value1).getTeamRelationList().size();i++) {
                    relationsList.add(teamsMap.get(value1).getTeamRelationList().get(i));
                }
            }
            teamsMap.get(teamId).setTeamRelationList(relationsList);
        }

        this.departmentsMap = new HashMap<>();
        for (Map.Entry<String, JsonValue> entry : companyRoot.getJsonObject("departments").entrySet()) {
            String departmentName = entry.getKey();
            JsonObject localizationObject = ((JsonObject)entry.getValue()).getJsonObject("localisations");
            Map<String, LocalizationDTO> localizationMap = new HashMap<>();
            for (Map.Entry<String, JsonValue> localizationEntry : localizationObject.entrySet()) {
                    String localizationName = localizationEntry.getKey();
                    List<Integer> teamIds = new ArrayList<>();
                    for (JsonValue id : ((JsonObject) localizationEntry.getValue()).getJsonArray("teams")) {
                            teamIds.add(new Integer(id.toString()));
                    }
                    localizationMap.put(localizationName, new LocalizationDTO(localizationName, teamIds));

            }
            this.departmentsMap.put(departmentName, new DepartmentDTO(departmentName, localizationMap));
        }
        LOG.info("CompanyDTO created");

        updateJson();
    }

    public void addDepartment(String name) throws Exception {
        if (departmentsMap.containsKey(name)) {
            throw new Exception("Department exists");
        } else {
            departmentsMap.put(name, new DepartmentDTO(name));
        }
    }

    public void addLocalization(String department, String localization) throws Exception {
        if (!departmentsMap.containsKey(department)) {
            throw new Exception("Department doesn't exists");
        } else if (departmentsMap.get(department).getLocalizationsMap().containsKey(localization)) {
            throw new Exception("Localization already exists");
        } else {
            departmentsMap.get(department).getLocalizationsMap().put(localization, new LocalizationDTO(name));
        }
    }

    public void addTeam(String department, String localization, String team) throws Exception {
        TeamDTO newTeam = new TeamDTO(getNewTeamId(), team, department, localization);
        if (teamsMap.containsValue(newTeam)) {
            throw new Exception("Team exists");
        } else if (!departmentsMap.containsKey(department)) {
            throw new Exception("Department doesn't exists");
        } else if (!departmentsMap.get(department).getLocalizationsMap().containsKey(localization)) {
            throw new Exception("Localization doesn't exists");
        } else {
            teamsMap.put(newTeam.getId(), newTeam);
            departmentsMap.get(department).getLocalizationsMap().get(localization).getTeamDTOList().add(newTeam.getId());
        }
    }

    public void clearData() {
        teamsMap.clear();
        departmentsMap.clear();
    }

    public List <TeamDTO> getTeamAssociates(String department, String localization, String team){
        List <TeamDTO> associates = new ArrayList<TeamDTO>();
        List <Integer> idAssociates = new ArrayList<Integer>();
        /*for(int i = 0; i<teamsMap.size();i++) {
                teamsMap.
            }
        */
        //TODO
        return associates;
    }

    private Integer getNewTeamId() {
        return Collections.max(teamsMap.keySet())+1;
    }

    private void updateJson() {
        ObjectMapper mapper = new ObjectMapper();

        try {
            // Convert object to JSON string and save into a file directly
            mapper.writeValue(new File("test.json"), this);

            // Convert object to JSON string
            String jsonInString = mapper.writeValueAsString(this);
            System.out.println(jsonInString);

            // Convert object to JSON string and pretty print
            jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
            System.out.println(jsonInString);

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "CompanyDTO{" +
                "name='" + name + '\'' +
                ", departmentsMap=" + departmentsMap +
                ", teamsMap=" + teamsMap +
                '}';
    }
}
