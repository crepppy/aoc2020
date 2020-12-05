package com.jackchapman.adventofcode


// Completed in 5mins 56seconds
fun solveDay5(): Pair<Int, Int> {
    val boardingPasses =
        {}::class.java.classLoader.getResourceAsStream("Day05.txt")?.bufferedReader()?.readLines()
            .orEmpty()

    val ids: List<Int> = boardingPasses.map { boardingPassSeat(it) }

    val myId = (ids.minOrNull()!!..ids.maxOrNull()!!) - ids

    return (ids.maxOrNull() ?: 0) to myId[0]
}

fun boardingPassSeat(boardingPass: String): Int {
    return boardingPass.map { char ->
        when (char) {
            'B', 'R' -> '1'
            'F', 'L' -> '0'
            else -> throw IllegalArgumentException("$boardingPass is in an invalid format")
        }
    }.joinToString("").let { it.take(7).toInt(2) shl 3 xor it.takeLast(3).toInt(2) }
}



