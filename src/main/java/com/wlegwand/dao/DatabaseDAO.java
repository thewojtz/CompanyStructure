package com.wlegwand.dao;


import com.wlegwand.dto.DepartmentDTO;
import com.wlegwand.dto.LocalizationDTO;
import com.wlegwand.dto.TeamDTO;

import javax.json.*;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseDAO {

    private static final String DATABASE_FILENAME = "database.json";
    //private List<TeamDTO> teamContainer = new ArrayList<TeamDTO>();
    private static DatabaseDAO instance;


    private static File file;

    private DatabaseDAO() {
        ClassLoader classLoader = getClass().getClassLoader();
        file = new File(classLoader.getResource(DATABASE_FILENAME).getFile());
    }

    public static DatabaseDAO getInstance() {
        if (instance == null) {
            instance = new DatabaseDAO();
        }
        return instance;
    }

    public JsonObject getData() {
        try {
            JsonReader jsonReader = Json.createReader(new FileReader(file));
            return jsonReader.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void writeData(JsonObject jsonObject) {
        try {
            JsonWriter jsonWriter = Json.createWriter(new FileWriter(file));
            jsonWriter.writeObject(jsonObject);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
