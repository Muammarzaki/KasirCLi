package com.kasircli.models.entity;

import java.nio.file.Paths;
import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JsonHandlerTest {

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void testDelete() {

    }

    @Test
    public void testInit() {

    }

    @Test
    public void testLoadAllFile() {

    }

    @Test
    public void testLoadFile() {

    }

    @Test
    public void testMain() {

    }

    @Test
    public void testSaveFile() {
        HashMap<String, String> map = new HashMap<>();
        map.put("name", "amas");

        var jsonHandler = new JsonHandler();
        jsonHandler.saveFile(Paths.get(jsonHandler.jsonfile), map);
    }
}
