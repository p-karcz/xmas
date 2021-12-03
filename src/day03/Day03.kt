package day03

import readInput

typealias sizeMethod = (Int, Int) -> Char

fun main() {
    val input = readInput("day03/day03")
    part1(input)
    part2(input)
}

fun part2(input: List<String>) {
    val oxygen = filterProgressivelyWithCondition(::majority, input)
    val carbon = filterProgressivelyWithCondition(::minority, input)
    println(oxygen * carbon)
}

fun part1(input: List<String>) {
    var gammaBitRepresentation = EMPTY_STRING
    len(input).forEach { index ->
        val ones = input.count { line -> line[index] == UP }
        gammaBitRepresentation += majority(input.size, ones)
    }

    val gamma = Integer.parseInt(gammaBitRepresentation, 2)
    val epsilon = Integer.parseInt(gammaBitRepresentation.reverse(), 2)
    println(gamma * epsilon)
}

fun filterProgressivelyWithCondition(sizeMethod: sizeMethod, input: List<String>): Int {
    var workingCopy = input
    var index = 0
    while (workingCopy.size > 1) {
        val ones = workingCopy.count { line -> line[index] == UP }
        workingCopy = workingCopy.filter { line ->
            line[index] == sizeMethod(workingCopy.size, ones) || areTheSameAtIndex(workingCopy, index)
        }
        index++
    }
    return Integer.parseInt(workingCopy.first(), 2)
}

fun areTheSameAtIndex(input: List<String>, index: Int) =
    !(input.any { it[index] == UP } && input.any { it[index] == DOWN })

fun majority(size: Int, onesCount: Int) = if (onesCount >= (size + 1) / 2) UP else DOWN

fun minority(size: Int, onesCount: Int) = if (onesCount >= (size + 1) / 2) DOWN else UP

fun len(input: List<String>) = input[0].indices

fun String.reverse(): String {
    return this.replace(UP, TEMP).replace(DOWN, UP).replace(TEMP, DOWN)
}

const val EMPTY_STRING = ""
const val UP = '1'
const val DOWN = '0'
const val TEMP = '#'