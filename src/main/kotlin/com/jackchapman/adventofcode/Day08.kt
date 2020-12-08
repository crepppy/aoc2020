package com.jackchapman.adventofcode

fun solveDay8(): Pair<Int, Int> {
    val instructions = getInput(8)

    return calculateAccBeforeRepeat(instructions) to calculateAccAfterInstructionChange(instructions)
}

// Completed in 4mins 5seconds
fun calculateAccBeforeRepeat(instructions: List<String>): Int {
    return runInstructions(instructions).second
}

// Refactored instruction running and completed below function in 8mins 23seconds
fun calculateAccAfterInstructionChange(instructions: List<String>): Int {
    for ((index, inst) in instructions.withIndex()) {
        if (inst.take(3) != "acc") {
            val changedInstructions = instructions.toMutableList()
            changedInstructions[index] = (if (inst.take(3) == "nop") "jmp" else "nop") + inst.drop(3)
            val result = runInstructions(changedInstructions)

            if (result.first >= changedInstructions.size - 1)
                return result.second
        }
    }
    return -1
}

private fun runInstructions(instructions: List<String>): Pair<Int, Int> {
    var instLoc = 0
    var acc = 0
    val visited: MutableSet<Int> = mutableSetOf()
    while (instLoc !in visited && instLoc < instructions.size) {
        val instruction = instructions[instLoc]
        visited.add(instLoc)
        when (instruction.take(3)) {
            "acc" -> acc += instruction.drop(4).toInt()
            "jmp" -> {
                instLoc += instruction.drop(4).toInt()
                continue
            }
        }
        instLoc++
    }
    return instLoc to acc
}
