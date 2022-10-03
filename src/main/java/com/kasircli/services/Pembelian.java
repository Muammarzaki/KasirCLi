package com.kasircli.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

import com.kasircli.helpers.JsonHandler;
import com.kasircli.models.Product;

public class Pembelian implements Runnable {
    JsonHandler jh = new JsonHandler();
    InputStreamReader inputReader = new InputStreamReader(System.in);
    BufferedReader reader = new BufferedReader(inputReader);

    @Override
    public void run() {
        // todo integer harus positif
        new JsonHandler().init();
        System.out.println("""

                Pembelian
                -----------------------------""");

        int inputUserPembelian = inputUserPembelian();

        System.out.printf("""

                -----------------------------
                total : Rp.%,d

                """, inputUserPembelian);

    }

    public int inputUserPembelian() {
        List<Integer> totalCount = new ArrayList<>();
        HashMap<String, Integer> produkBuying = new HashMap<>();
        Integer price;

        while (true) {
            String userInput;

            try {
                System.out.print(">");
                userInput = reader.readLine().trim();
            } catch (IOException e) {
                System.out.println("something wrong or your input not valid");
                continue;
            }
            if (userInput.equals("")) {
                continue;
            }
            if (userInput.equals("q")) {
                break;
            }
            try {
                if (userInput.contains(" ")) {

                    String[] split = userInput.split(" ");
                    price = searchPriceByName(split[0]) * Integer.valueOf(split[1]);
                    System.out.printf("=> Rp.%,d \n", price);
                    totalCount.add(price);
                    isProductSame(produkBuying, split[0], price);

                } else {
                    price = searchPriceByName(userInput);
                    System.out.printf("=> Rp.%,d \n", price);
                    totalCount.add(price);
                    isProductSame(produkBuying, userInput, price);
                }

            } catch (NoSuchElementException e) {
                System.err.println("Product not found");
            } catch (NumberFormatException e) {
                System.err.println("use format [Product] [amount:number]");
            } catch (Exception e) {
                System.err.println(e);

            }

        }
        return totalCount.stream().mapToInt(i -> i.intValue()).sum();

    }

    public Integer searchPriceByName(String ProduckName) {
        Product search = this.jh.search(ProduckName).get();
        return search.getPrice();
    }

    public void isProductSame(HashMap<String, Integer> tmpProduct, String key, Integer value) {
        if (tmpProduct.containsKey(key)) {
            tmpProduct.put(key, tmpProduct.get(key) + value);
        } else {
            tmpProduct.put(key, value);
        }
    }

    public void changeProduck() {
        // todo this must complite oke
    }
}
