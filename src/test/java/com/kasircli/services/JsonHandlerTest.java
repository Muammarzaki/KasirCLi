package com.kasircli.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.kasircli.helpers.JsonHandler;
import com.kasircli.models.Product;

public class JsonHandlerTest {

    @BeforeEach
    public void setUp() {
    }

    @Test
    @Order(5)
    public void testDelete() {
        JsonHandler json = new JsonHandler();

        json.delete(json.search("ayam").get().getId());
    }

    @Test
    @Order(1)
    public void testInit() {
        var jsonHandler = new JsonHandler();
        jsonHandler.init();
    }

    @Test
    @Order(4)
    public void testLoadAllFile() {
        var jsonHandler = new JsonHandler();
        assertNotNull(jsonHandler.loadAllFile());
    }

    @Test
    @Order(3)
    public void testsearch() {
        var jsonHandler = new JsonHandler();
        assertNotNull(jsonHandler.search("ayam"));
    }

    @Test
    @Order(2)
    public void testSaveFile() {

        var jsonHandler = new JsonHandler();
        jsonHandler.init();
        assertTrue(jsonHandler.saveFile(List.of(new Product("ayam", 3000, 10))));
    }
}