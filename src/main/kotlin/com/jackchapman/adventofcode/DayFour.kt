package com.jackchapman.adventofcode

val requiredFields: Map<String, (String) -> Boolean> = mapOf(
    "byr" to { it.toIntOrNull() ?: 0 in 1920..2002 },
    "iyr" to { it.toIntOrNull() ?: 0 in 2010..2020 },
    "eyr" to { it.toIntOrNull() ?: 0 in 2020..2030 },
    "hgt" to {
        val height = it.dropLast(2).toIntOrNull() ?: 0
        val unit = it.takeLast(2)
        (unit == "cm" && height in 150..193) || (unit == "in" && height in 59..76)
    },
    "hcl" to { it.length == 7 && it.takeLast(6).toIntOrNull(16) != null },
    "ecl" to { it in listOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth") },
    "pid" to { it.length == 9 && it.toIntOrNull() != null }
)

fun main() {
    val passports: List<String> =
        {}::class.java.classLoader.getResourceAsStream("DayFour.txt")?.bufferedReader()?.readLines()
            .orEmpty().joinToString("\n").split("\n\n")

    val valid1 = passports.count { isValidPassport(it, false) }
    val valid2 = passports.count { isValidPassport(it) }

    println("Part 1: $valid1")
    println("Part 2: $valid2")
}

// Completed in 20mins 43seconds
fun isValidPassport(passport: String, usePredicate: Boolean = true): Boolean {
    val map: Map<String, String> = passport.split(" ", "\n").associate { it.take(3) to it.drop(4) }
    return requiredFields.all { it.value.invoke(map[it.key] ?: return false) || !usePredicate }
}