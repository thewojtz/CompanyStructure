package com.wlegwand;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 */
public class MainTest {

    @Test
    public void testAddTeam() throws Exception {
       Main main = new Main();
       String result = main.addTeam("testDepartment","testLocalization","testTeam");
       Assert.assertEquals(result, "Department added");

    }
    @Test
    public void testAddLocalization() throws Exception {
        Main main = new Main();
        String result = main.addLocalization("testDepartment","testLocalization");
        Assert.assertEquals(result, "Localization added");

    }
    @Test
    public void testAddDepartment() throws Exception {
        Main main = new Main();
        String result = main.addDepartment("testDepartment");
        Assert.assertEquals(result, "Department added");

    }



}