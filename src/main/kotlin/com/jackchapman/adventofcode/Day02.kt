package com.jackchapman.adventofcode

fun solveDay2(): Pair<Int, Int> {
    val passwords: List<String> = getInput(2)

    val matchingCount = passwords.count { isValidCount(it) }
    val matchingPosition = passwords.count { isValidPosition(it) }

    return matchingCount to matchingPosition
}

// Completed in 7mins 02secs
fun isValidCount(passString: String): Boolean {
    val (condition, password) = passString.split(": ")
    val char = condition[condition.lastIndex]
    val count = password.count { it == char }

    val (lower, higher) = condition.substring(0, condition.lastIndex).split("-")
    return lower.trim().toInt() <= count && count <= higher.trim().toInt()
}

// Completed in 1min 35secs
fun isValidPosition(passString: String): Boolean {
    val (condition, password) = passString.split(": ")
    val char = condition[condition.lastIndex]

    val (pos1, pos2) = condition.substring(0, condition.lastIndex).split("-")
    return (password[pos1.trim().toInt() - 1] == char) xor (password[pos2.trim().toInt() - 1] == char)
}