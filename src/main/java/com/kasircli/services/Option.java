package com.kasircli.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import picocli.CommandLine.Command;

/**
 * Option
 */

@Command(name = "start")
public class Option implements Runnable {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public void run() {
        ExecutorService exe = Executors.newSingleThreadExecutor();

        System.out.print(this.startMenu());
        try {
            String input = reader.readLine().trim().toLowerCase();
            if (input.equals("0") || input.equals("q")) {
            } else {

                if (input.equals("1")) {
                    exe.submit(new Pembelian());

                } else if (input.equals("2")) {
                    exe.submit(new Insert());

                } else if (input.equals("3")) {
                    // exe.submit();
                } else if (input.equals("4")) {
                    // exe.submit();
                } else {
                    System.err.println("---select one of option---");
                }
                exe.submit(new Option());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        exe.shutdown();
    }

    public String startMenu() {
        return new String("""
                =========KASIR CLI=========
                1> PEMBELIAN
                2> TAMBAH DATA
                3> DELETE
                4> ISI STOCK
                ---------------------------
                 :  """);
    }

}