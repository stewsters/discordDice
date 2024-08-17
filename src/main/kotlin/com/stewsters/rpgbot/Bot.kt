package com.stewsters.rpgbot

import com.jessecorbett.diskord.bot.*
import com.jessecorbett.diskord.bot.interaction.interactions
import dev.diceroll.parser.ResultTree
import dev.diceroll.parser.detailedRoll
import java.io.File

// This file contains the discord token.  Dont commit it.
val BOT_TOKEN = File(".token").readText()

// To add this to your server, use this url
// https://discordapp.com/api/oauth2/authorize?client_id=706710836235862068&permissions=67584&scope=bot
suspend fun main() {

    bot(BOT_TOKEN) {
        interactions {
            slashCommand("roll", "roll dice") {

                val dice by stringParameter("dice", "Dice expressions", optional = true)
                callback {
                    respond {
                        content = if (dice != null) {

                            println("|$dice|")

                            val resultTree: ResultTree = detailedRoll(dice!!)
//                            val result: Int = resultTree.value()

//                            val rolls = parser.parse(dice?.replace("/w", ""), roller)

//                            val response = rolls.rollResults.map {
//                                "${it.dice.quantity}d${it.dice.sides}" + "[" + it.allRolls.joinToString(", ") + "]"
//                            }.joinToString(" + ") + " = ${rolls.totalRoll}"

//                            response
                            val response = "${resultTree.expression.description()} = ${resultTree.value}"
                            response

                        } else {
                            "The message was null, because it is optional"
                        }
                    }
                }
            }

            classicCommands("!") {
                command("ping") {
                    it.respond("pong")
                }
            }

        }
    }
}