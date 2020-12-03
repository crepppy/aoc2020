package com.jackchapman.adventofcode

fun main() {
    val expenseReport: List<Int> =
        {}::class.java.classLoader.getResourceAsStream("DayOne.txt")?.bufferedReader()?.readLines()
            ?.map { it.toInt() }
            .orEmpty()
    println("Part 1: ${find2020SumOfTwo(expenseReport)}")
    println("Part 2: ${find2020SumOfThree(expenseReport)}")
}

fun find2020SumOfTwo(expenses: List<Int>): Int {
    for (i in expenses) {
        for (j in expenses) {
            if (i + j == 2020) {
                return i * j
            }
        }
    }
    return -1
}

fun find2020SumOfThree(expenses: List<Int>): Int {
    for (i in expenses) {
        for (j in expenses) {
            for (k in expenses) {
                if (i + j + k == 2020) {
                    return i * j * k
                }
            }
        }
    }
    return -1
}