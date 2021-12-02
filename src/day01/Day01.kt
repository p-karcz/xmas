package day01

import readInput

fun main() {
    val input = readInput("day01/day01").map { it.toInt() }
    part1(input)
    part2(input)
}

fun part2(input: List<Int>) {
    val lines = input
        .zipWithNext { prev, next -> prev + next }
        .zip(input.drop(2)) { sumOfTwo, third -> sumOfTwo + third }
    part1(lines)
}

fun part1(input: List<Int>) {
    var result = 0
    for (index in 1 until input.size) {
        if (input[index] > input[index - 1]) result++
    }
    println(result)
}
