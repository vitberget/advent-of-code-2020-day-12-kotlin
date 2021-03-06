package se.vbgt.aoc.year2020.day7.part1

fun day7part1(mapOfBags: Map<String, Map<String, Int>>) {
    val targetBagName = "shiny gold"

    val count = mapOfBags.keys
        .count { canContainBag(mapOfBags, it, targetBagName) }

    println("Day7 part1: ${count}")
}

fun canContainBag(mapOfBags: Map<String, Map<String, Int>>, bagName: String, targetBagName: String): Boolean {
    val contents = mapOfBags[bagName]
    return contents != null &&
            (contents.containsKey(targetBagName) || contents.keys.any { canContainBag(mapOfBags, it, targetBagName) })
}
