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
    JsonHandler jsonHandler;

    @BeforeEach
    public void setUp() {
        jsonHandler = new JsonHandler();
    }

    @Test
    @Order(5)
    public void testDelete() {
        jsonHandler.delete(jsonHandler.search("ayam").get().getId());
    }

    @Test
    @Order(1)
    public void testInit() {
        jsonHandler.init();
    }

    @Test
    @Order(4)
    public void testLoadAllFile() {
        assertNotNull(jsonHandler.loadAllFile());
    }

    @Test
    @Order(3)
    public void testsearch() {
        assertNotNull(jsonHandler.search("ayam"));
    }

    @Test
    @Order(2)
    public void testSaveFile() {
        jsonHandler.init();
        assertTrue(jsonHandler.saveFile(List.of(new Product("ayam", 3000, 10))));
    }
}