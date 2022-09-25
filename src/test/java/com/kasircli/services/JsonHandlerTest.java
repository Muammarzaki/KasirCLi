package com.kasircli.services;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.kasircli.utils.DataModel;

public class JsonHandlerTest {

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void testDelete() {
        List<Integer> of = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9).stream().filter(x -> x.equals(3)).toList();
        JsonHandler json = new JsonHandler();

        json.delete("amar");
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
        jsonHandler.init();
        jsonHandler.saveFile(List.of(new DataModel(1, "amar", 1, "amar")));
    }
}
