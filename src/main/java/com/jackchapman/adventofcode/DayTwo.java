package com.jackchapman.adventofcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DayTwo {
    public static void main(String[] args) {
        List<String> passwords = new ArrayList<>();
        try (InputStreamReader streamReader = new InputStreamReader(Objects.requireNonNull(DayOne.class.getClassLoader().getResourceAsStream("DayTwo.txt")));
             BufferedReader reader = new BufferedReader(streamReader)) {
            String line;
            while ((line = reader.readLine()) != null) {
                passwords.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Part 1: " + passwords.stream().filter(DayTwo::isValidCount).count());
        System.out.println("Part 2: " + passwords.stream().filter(DayTwo::isValidPosition).count());
    }

    public static boolean isValidCount(String passString) {
        String[] passSplit = passString.split(": ");
        String condition = passSplit[0];
        String password = passSplit[1];
        char c = condition.charAt(condition.length() - 1);
        long count = password.chars().filter(x -> c == ((char)x)).count();

        condition = condition.substring(0, condition.length() - 1);
        String[] conditionSplit = condition.split("-");
        int lower = Integer.parseInt(conditionSplit[0].trim());
        int higher = Integer.parseInt(conditionSplit[1].trim());
        return lower <= count && count <= higher;
    }

    public static boolean isValidPosition(String passString) {
        String[] passSplit = passString.split(": ");
        String condition = passSplit[0];
        String password = passSplit[1];
        char c = condition.charAt(condition.length() - 1);

        condition = condition.substring(0, condition.length() - 1);
        String[] conditionSplit = condition.split("-");
        int pos1 = Integer.parseInt(conditionSplit[0].trim());
        int pos2 = Integer.parseInt(conditionSplit[1].trim());
        return password.charAt(pos1-1) == c ^ c == password.charAt(pos2-1);
    }
}
