package com.kasircli.services;

/**
 * Option
 */
public class Option {
    public static void main(String[] args) {
        new Option();
    }

    public String startMenu() {
        return new String("""
                =========KASIR CLI=========

                1> PEMBELIAN
                2> TAMBAH DATA
                3> DELETE
                4> ISI STOCK

                """);
    }

}