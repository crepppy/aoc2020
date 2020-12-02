package com.jackchapman.adventofcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DayOne {
    public static void main(String[] args) throws IOException {
        List<Integer> expenseReport = new ArrayList<>();
        try (InputStreamReader streamReader = new InputStreamReader(Objects.requireNonNull(DayOne.class.getClassLoader().getResourceAsStream("DayOne.txt")));
             BufferedReader reader = new BufferedReader(streamReader)) {
            String line;
            while ((line = reader.readLine()) != null) {
                expenseReport.add(Integer.parseInt(line));
            }
        }
        System.out.println("Part 1: " + find2020SumOfTwo(expenseReport));
        System.out.println("Part 2: " + find2020SumOfThree(expenseReport));
    }

    public static int find2020SumOfTwo(List<Integer> expenses) {
        for (int i : expenses) {
            for (int j : expenses) {
                if (i + j == 2020) {
                    return i * j;
                }
            }
        }
        return -1;
    }

    public static int find2020SumOfThree(List<Integer> expenses) {
        for (int i : expenses) {
            for (int j : expenses) {
                for (int k : expenses) {
                    if (i + j + k == 2020) {
                        return i * j * k;
                    }
                }
            }
        }
        return -1;
    }
}
