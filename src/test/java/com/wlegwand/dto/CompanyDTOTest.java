package com.wlegwand.dto;

import com.wlegwand.dao.DatabaseDAO;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by Adam on 2017-11-21.
 */
public class CompanyDTOTest {

    @Test
    public void testCompanyDTOCreate() throws Exception {
        DatabaseDAO databaseDAO = DatabaseDAO.getInstance();
        CompanyDTO companyDTO = new CompanyDTO(databaseDAO.getData());
    }
}