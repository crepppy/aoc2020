package com.jackchapman.adventofcode


fun solveDay6(): Pair<Int, Int> {
    val groupAnswers = getInput(6).joinToString("\n").split("\n\n")

    val answered = groupAnswers.map { questionsAnswered(it) }
    val commonAnswers = groupAnswers.map { questionsEveryoneAnswered(it) }
    return answered.sum() to commonAnswers.sum()
}

// Completed in 1min 58seconds
fun questionsAnswered(group: String): Int {
    val s = group.toCharArray().toMutableSet()
    s.remove('\n')
    return s.size
}

// Completed in 3mins 26seconds
fun questionsEveryoneAnswered(group: String): Int {
    val questions = group.toCharArray().toMutableSet()
    val size = group.lines().size
    questions.remove('\n')
    return questions.count { group.count { c -> c == it } == size }
}


