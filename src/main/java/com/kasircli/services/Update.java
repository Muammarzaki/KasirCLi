package com.kasircli.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

import com.kasircli.helpers.JsonHandler;
import com.kasircli.models.Product;
import com.kasircli.models.dto.ProductUpdate;

public class Update implements Runnable {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
    List<Product> dataUpdate = new ArrayList<>();
    JsonHandler jsh = new JsonHandler();

    @Override
    public void run() {
        try {
            List<Product> allProduct = jsh.loadAllFile();

            ProductUpdate dataFromUser = this.getDataFromUser();
            Stream<Product> sal = allProduct.stream();

            Product productFromStream = sal.filter(x -> x.getName().equals(dataFromUser.getName())).findFirst().get();

            if (!(dataFromUser.getName().length() > 0 || productFromStream == null)) {
                throw new NoSuchElementException("value not found");
            }
            if (dataFromUser.getPrice() != null) {
                productFromStream.setPrice(dataFromUser.getPrice());
            }
            if (dataFromUser.getStock() != null) {
                productFromStream.setStock(dataFromUser.getStock());
            }
            if (dataFromUser.getDescription().length() > 0) {
                productFromStream.setDescription(dataFromUser.getDescription());
            }

            Stream<Product> map = allProduct.stream()
                    .map(x -> x.getName().equals(productFromStream.getName()) ? productFromStream : x);
            jsh.writeToFile(map.toList());
        } catch (NoSuchElementException e) {
            System.err.println(e.getMessage());

        } catch (NullPointerException e) {
            System.err.println(e.getMessage());

        } catch (Exception e) {
            System.err.println(e.getMessage());

        }
    }

    public ProductUpdate getDataFromUser() {
        try {
            ProductUpdate productUpdate = new ProductUpdate();
            System.out.print("product : ");
            productUpdate.setName(read.readLine().trim());

            System.out.print("price : ");
            productUpdate.setPrice(Integer.valueOf(read.readLine().trim()));

            System.out.print("stock : ");
            productUpdate.setStock(Integer.valueOf(read.readLine().trim()));

            System.out.print("desk : ");
            productUpdate.setDescription(read.readLine().trim());

            return productUpdate;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
