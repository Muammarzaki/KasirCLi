package com.kasircli.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.List;

import com.kasircli.helpers.JsonHandler;
import com.kasircli.models.Product;

public class Insert implements Runnable {
    JsonHandler jsh = new JsonHandler();

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public void run() {
        callInsertManualy();

    }

    private void callInsertManualy() {
        try {
            System.out.print("how many data wanna insert? : ");
            String input = reader.readLine();
            input.trim();
            if (input.equals("0") || input.equals("q")) {

            } else {
                Integer round = Integer.valueOf(input);
                System.out.println("================START===============");
                for (int i = 0; i < round; i++) {
                    insertProductManual();
                }
                System.out.println("================END===============");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertProductManual() {
        try {

            System.out.printf("Name :");
            String productName = reader.readLine();
            productName.trim().replace(" ", "-");

            System.out.print("Price:");
            String productPrice = reader.readLine();
            productPrice.trim();

            System.out.print("Stock:");
            String productStock = reader.readLine();
            productStock.trim();

            System.out.print("deskripsi:");
            String deks = reader.readLine();
            deks.trim();

            if (productName.equals("") || productPrice.equals("")) {
                throw new NullPointerException("name & price cannot be null");
            } else {

                jsh.saveFile(
                        List.of(new Product(productName, Integer.valueOf(productPrice),
                                Integer.valueOf(productStock))
                                .setDescription(deks)));

                System.out.println("=====================>SUCCESS\n");
            }
        } catch (NumberFormatException e) {
            System.err.println("Price & stock must be number");
            System.out.println("========================>FAIL\n");

        } catch (IOException | NullPointerException e) {
            System.err.println(e.getMessage());
            System.out.println("========================>FAIL\n");
        }
    }

    public void insertByCsv(Path path) {

    }

}
