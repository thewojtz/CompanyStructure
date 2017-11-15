package com.wlegwand.dto;

import java.util.List;

public class TeamDTO {

    private String departament;
    private String localization;
    private List<TeamDTO> teamRelationList;

    public TeamDTO() {
    }

    public TeamDTO(String departament, String localization, List<TeamDTO> teamRelationList) {
        this.departament = departament;
        this.localization = localization;
        this.teamRelationList = teamRelationList;
    }
}
