package day02

import readInput

fun main() {
    val input = readInput("day02/day02")
    part1(input)
    part2(input)
}

fun part1(input: List<String>) {
    var distance = 0
    var depth = 0

    input.forEach {
        if (it.contains("forward")) {
            distance += it.split(' ')[1].toInt()
        } else if (it.contains("down")) {
            depth += it.split(' ')[1].toInt()
        } else {
            depth -= it.split(' ')[1].toInt()
        }
    }
    println(distance * depth)
}

fun part2(input: List<String>) {
    var aim = 0
    var distance = 0
    var depth = 0

    input.forEach {
        if (it.contains("forward")) {
            val move = it.split(' ')[1].toInt()
            distance += move
            depth += aim * move
        } else if (it.contains("down")) {
            aim += it.split(' ')[1].toInt()
        } else {
            aim -= it.split(' ')[1].toInt()
        }
    }
    println(distance * depth)
}