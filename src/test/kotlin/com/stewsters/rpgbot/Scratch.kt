package com.stewsters.rpgbot

fun main() {
    val text = "2d20+1d6+7"
    val rolls = parser.parse(text, roller)

    println(rolls.rollResults.map {

        "${it.dice.quantity}d${it.dice.sides}" + "[" + it.allRolls.joinToString(", ") + "]"
    }.joinToString(" + ")+" = ${rolls.totalRoll}")
}