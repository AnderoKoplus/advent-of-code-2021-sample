package org.example.aoc2021sample.day01;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Integer> loadListOfInteger(String inputFile) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader(inputFile));
        ArrayList<Integer> input = new ArrayList<>();
        while (sc.hasNext()) {
            if (sc.hasNextInt()) {
                input.add(sc.nextInt());
            } else {
                sc.next();
            }
        }
        sc.close();
        return input;
    }

    public static void main(String[] args) throws FileNotFoundException {
        long start = System.currentTimeMillis();
        String filename = System.getenv("INPUT_DAY01_01");
        List<Integer> input = loadListOfInteger(filename);
        System.out.println(getTotalFuel(input));
        int totalFuel = 0;
        for (int mass : input) {
            totalFuel += getIncrementalFuel(mass);
        }
        System.out.println(totalFuel);
        System.out.println("Time: " + (System.currentTimeMillis() - start));
    }

    private static int getIncrementalFuel(int mass) {
        int fuel = (mass / 3) - 2;

        if (fuel <= 0) {
            return 0;
        }
        return fuel + getIncrementalFuel(fuel);
    }

    private static int getTotalFuel(List<Integer> input) {
        int totalFuel = 0;
        for (int mass : input) {
            totalFuel += ((mass / 3) - 2);
        }
        return totalFuel;
    }
}
