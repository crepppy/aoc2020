package com.jackchapman.adventofcode

fun solveDay7(): Pair<Int, Int> {
    val rules = getInput(7)
    val colorMap = parseBagRules(rules)

    val numberOfBagsThatHold = colorMap.keys.count {
        canContainBag("shiny gold", it, colorMap)
    }

    return numberOfBagsThatHold to numberOfContainedBags("shiny gold", colorMap)
}

// Completed parseBagRules and canContainBag in 17mins 8seconds
fun canContainBag(findBag: String, curBag: String, bags: Map<String, List<Pair<Int, String>>>): Boolean {
    if (bags[curBag]!!.any { it.second == findBag }) return true
    if (bags[curBag]!!.isEmpty()) return false

    return bags[curBag]!!.any { canContainBag(findBag, it.second, bags) }
}

fun parseBagRules(rules: List<String>): Map<String, List<Pair<Int, String>>> {
    val bagRegex = Regex("(\\d+) ([\\w\\s]+) bags?")
    val colorMap: MutableMap<String, List<Pair<Int, String>>> = mutableMapOf()
    rules.forEach {
        val color = it.substringBefore("bags").trim()
        if (it.endsWith("no other bags.")) colorMap[color] = emptyList()
        else {
            colorMap[color] = bagRegex.findAll(it)
                .map { colorMatch -> colorMatch.groupValues[1].toInt() to colorMatch.groupValues[2] }.toList()
        }
    }
    return colorMap
}

// Completed in 7mins 8seconds
fun numberOfContainedBags(bag: String, rules: Map<String, List<Pair<Int, String>>>): Int {
    return rules[bag]!!.sumBy { it.first + it.first * numberOfContainedBags(it.second, rules) }
}

