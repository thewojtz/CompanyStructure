package com.wlegwand.dao;


import javax.json.*;

import java.io.*;

public class DatabaseDAO {

    private static final String DATABASE_FILENAME = "database.json";

    private static DatabaseDAO instance;

    private File file;

    private DatabaseDAO() {
        ClassLoader classLoader = getClass().getClassLoader();
        file = new File(classLoader.getResource(DATABASE_FILENAME).getFile());
        System.out.println("lolololo");
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

    public void writeData(JsonObject jsonObject) {
        try {
            JsonWriter jsonWriter = Json.createWriter(new FileWriter(file));
            jsonWriter.writeObject(jsonObject);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
