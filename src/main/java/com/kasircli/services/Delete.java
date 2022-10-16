package com.kasircli.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;

import com.kasircli.helpers.JsonHandler;

public class Delete implements Runnable {
    JsonHandler jsh = new JsonHandler();
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    public Boolean call() {

        try {
            System.out.print("Product name for delete : ");
            String key = read.readLine().trim();
            if (key.equals("q")) {
                System.out.println("no data deleted");
                return true;
            }
            jsh.delete(jsh.search(key).get().getId());
            return true;
        } catch (NoSuchElementException e) {
            System.err.println(e.getMessage());
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void run() {
        Boolean isdelete = false;
        while (!isdelete) {
            isdelete = call();
        }
    }

}
