package com.wlegwand.dao;

import org.testng.annotations.Test;

import javax.json.JsonObject;

public class DatabaseDAOTest {

    @Test
    public void testGetInstance() throws Exception {
        DatabaseDAO databaseDAO = DatabaseDAO.getInstance();
        JsonObject rootObject = databaseDAO.getData();
        JsonObject companyObject = rootObject.getJsonObject("company");

        System.out.println(companyObject.getJsonObject("departments"));


    }

}