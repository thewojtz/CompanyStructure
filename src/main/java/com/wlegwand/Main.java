package com.wlegwand;

import com.wlegwand.dao.DatabaseDAO;
import com.wlegwand.dto.TeamDTO;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class Main {

    Main(){
        DatabaseDAO companyDatabase = DatabaseDAO.getInstance();
    }


    @RequestMapping("/addDepartment")
    String addDepartment(@RequestParam(value="department") String department) {
        return department;
    }
    @RequestMapping("/addLocalization")
    String addLocalization(@RequestParam(value="department") String department, @RequestParam(value="localization") String localization) {
        return department+" "+localization;
    }
	@RequestMapping("/addTeam")
    String addTeam(@RequestParam(value="department") String department, @RequestParam(value="localization") String localization, @RequestParam(value="team") String team) {

        return department+" "+localization+" "+team;
    }
    @RequestMapping("/addAssociates")
    String addAssociates(@RequestParam(value="department") String department, @RequestParam(value="localization") String localization, @RequestParam(value="team") String team) {

        return department+" "+localization+" "+team;
    }


    /*
	@RequestMapping("/getTeamAssociates")
    List<TeamDTO> getTeamAssociates(@RequestParam(value="department") String department, @RequestParam(value="localization") String localization, @RequestParam(value="team") String team) {
		return getAssociates(department, localization, team);
	}
	*/

    @RequestMapping("/getCompanyStructureTree")
    void getCompanyStructureTree() {

    }

    @RequestMapping("/removeCompanyStructureTree")
    void removeCompanyStructureTree() {

    }


	
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Main.class, args);
    }



}