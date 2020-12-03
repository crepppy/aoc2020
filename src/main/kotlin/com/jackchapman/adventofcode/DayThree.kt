package com.jackchapman.adventofcode

fun main() {
    val map: List<String> =
        {}::class.java.classLoader.getResourceAsStream("DayThree.txt")?.bufferedReader()?.readLines()
            .orEmpty()
    println("Part 1: ${getCollisions(map, 3)}")
    val prod = getCollisions(map) *
            getCollisions(map, 3) *
            getCollisions(map, 5) *
            getCollisions(map, 7) *
            getCollisions(map, down = 2)
    println("Part 2: $prod")
}

// Completed in 4mins 34seconds
fun getCollisions(map: List<String>, right: Int = 1, down: Int = 1): Long {
    var y = down
    var x = right
    var count: Long = 0
    while (y < map.size) {
        val row = map[y]
        if (row[x % row.length] == '#') count++
        y += down
        x += right
    }
    return count
}
