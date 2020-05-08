package com.stewsters.rpgbot

import com.bernardomg.tabletop.dice.interpreter.DiceRoller
import com.bernardomg.tabletop.dice.parser.DefaultDiceParser
import com.jessecorbett.diskord.dsl.bot
import com.jessecorbett.diskord.dsl.command
import com.jessecorbett.diskord.dsl.commands
import com.jessecorbett.diskord.util.words
import java.io.File


val parser = DefaultDiceParser();
val roller = DiceRoller();
val BOT_TOKEN = File(".token").readText()

// To add this to your server, use this url
// https://discordapp.com/api/oauth2/authorize?client_id=706710836235862068&permissions=67584&scope=bot
suspend fun main() {
    bot(BOT_TOKEN) {

        messageCreated {
            //println(it)
            if (it.content.contains("diskord")) {
                it.react("wut")
            }
        }
        commands ("/"){

            command("roll") {
                println(this.content)

                val text = this.content.removePrefix("/roll").replace(" ", "")
                val rolls = parser.parse(text, roller)

                val response = rolls.rollResults.map {
                    "${it.dice.quantity}d${it.dice.sides}" + "[" + it.allRolls.joinToString(", ") + "]"
                }.joinToString(" + ") + " = ${rolls.totalRoll}"

                reply(response)
            }

            command("ping") {
                println("Ping")
                reply("pong")
                delete()
            }

            command("echo") {
                reply(words.drop(1).joinToString(" "))
                delete()
            }


        }
    }
}