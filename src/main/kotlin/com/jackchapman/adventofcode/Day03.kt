package com.jackchapman.adventofcode

fun solveDay3(): Pair<Long, Long> {
    val map: List<String> = getInput(3)
    val prod = getCollisions(map) *
            getCollisions(map, 3) *
            getCollisions(map, 5) *
            getCollisions(map, 7) *
            getCollisions(map, down = 2)

    return getCollisions(map, 3) to prod
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
