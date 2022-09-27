package com.kasircli.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.Callable;

public class Input implements Callable {

    InputStreamReader inputReader = new InputStreamReader(System.in);
    BufferedReader reader = new BufferedReader(inputReader);

    @Override
    public Object call() throws Exception {
        return null;
    }

    public void inputUser() {
        String select;
        Integer totalCount;

        while (true) {
            String userInput;

            try {
                userInput = reader.readLine().trim();
            } catch (IOException e) {
                System.out.println("something wrong");
                continue;
            }

            if (userInput.equals("q")) {
                break;
            }
            if (userInput.contains(" ")) {

                String[] split = userInput.split(" ");
                // split[0];
                // split[1];

            }
        }

    }

    public void searchPriceByName(String ProduckName) {

    }

}
