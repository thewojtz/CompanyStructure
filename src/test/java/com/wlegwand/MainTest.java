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

        Assert.assertEquals(result, "User dded");

    }

    @Test
    public void testAddUser() throws Exception {
    }

    @Test
    public void testGetName() throws Exception {
    }

}