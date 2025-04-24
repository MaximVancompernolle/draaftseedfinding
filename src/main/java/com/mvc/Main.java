package com.mvc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Starting seed finding...");

        if (Config.FILTER_FILE) {
            filterFile(Config.INPUT_FILE, Config.OUTPUT_FILE);
        } else if (Config.FILTER_INCREMENTAL) {
            filterIncremental();
        } else {
            throw new RuntimeException("Define filter type as FILE or INCREMENTAL in com.mvc.Config");
        }

    }

    public static void filterFile(File inputFile, File outputFile) throws IOException {
        Scanner scanner = new Scanner(inputFile);
        FileWriter output = new FileWriter(outputFile);

        long seedsChecked = 0;
        int seedMatches = 0;
        long nextTime = 0;
        long currentTime;

        while (scanner.hasNextLong() && seedMatches < Config.SEED_MATCHES) {
            long structureSeed = scanner.nextLong();
            long matchedStructureSeed = filterStructureSeed(structureSeed) ? structureSeed : 0L;

            if (matchedStructureSeed != 0L) {
                output.write(matchedStructureSeed + "\n");
                seedMatches++;
            }
            seedsChecked++;
            currentTime = System.currentTimeMillis();

            if (currentTime > nextTime) {
                nextTime = currentTime + Config.LOG_DELAY;
                System.out.printf("%,d seeds checked with %,d matches\r", seedsChecked, seedMatches);
            }
        }
        output.close();
        System.out.printf("%,d seeds checked with %,d matches\r", seedsChecked, seedMatches);
    }

    public static void filterIncremental() {

    }

    public static boolean filterStructureSeed(long structureSeed) {
        return true;
    }
}