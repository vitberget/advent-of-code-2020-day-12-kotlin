package se.vbgt.aoc.year2020.day10.part1

fun part1(adapters: List<Int>): Int {
    val (threeGaps, oneGaps) = countGaps(adapters)
    return (threeGaps + 1) * (oneGaps + 1)
}

private fun countGaps(adapters: List<Int>): Pair<Int, Int> = countGaps(adapters, 0, 0)
private tailrec fun countGaps(adapters: List<Int>, oneGaps: Int, threeGaps: Int): Pair<Int, Int> {
    if (adapters.size < 2)
        return threeGaps to oneGaps

    val joltSize = nextJoltSize(adapters)

    return if (joltSize == 3)
        countGaps(adapters.drop(1), oneGaps, threeGaps + 1)
    else
        countGaps(adapters.drop(1), oneGaps + 1, threeGaps)
}

private fun nextJoltSize(adapters: List<Int>): Int {
    val (n1, n2) = adapters.take(2)
    return n2 - n1
}