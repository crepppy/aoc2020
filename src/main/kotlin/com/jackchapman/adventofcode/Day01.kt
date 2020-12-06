package com.jackchapman.adventofcode

fun solveDay1(): Pair<Int, Int> {
    val expenseReport: List<Int> = getInput(1).map { it.toInt() }
    return find2020SumOfTwo(expenseReport) to find2020SumOfThree(expenseReport)
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