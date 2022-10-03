package com.kasircli;

import com.kasircli.services.Option;

import picocli.CommandLine;
import picocli.CommandLine.Command;

/**
 * Hello world!
 *
 */
@Command(name = "ksr", version = "1.0.0", description = "kasir berbasis cli", subcommands = {
        Option.class }, mixinStandardHelpOptions = true)
public class App implements Runnable {
    public static void main(String[] args) {
        new CommandLine(new App()).execute(args);
    }

    @Override
    public void run() {
    }
}
