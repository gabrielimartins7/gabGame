package br.com.dimensao.gabgames.main

import br.com.dimensao.gabgames.model.Game
import br.com.dimensao.gabgames.model.Gamer
import br.com.dimensao.gabgames.services.Api
import transformAge
import java.util.Scanner

fun main() {
    val reading = Scanner(System.`in`)
    val gamer = Gamer.createGamer(reading)
    println("Registration completed successfully. Gamer data:")
    println(gamer)
    println("Gamer age: " + gamer.birth?.transformAge())

    var response: String

    do {
        println("Enter a game code to search: ")

        val search = reading.nextLine()

        val searchApi = Api()
        val infoGame = searchApi.searchGame(search)

        val myGame: Game = Game(infoGame.info.title, infoGame.info.thumb)

        val result = runCatching {
            myGame
        }

        result.onFailure {
            println("Nonexistent game. Try another id")
        }
        result.onSuccess {
            println("Want to enter a custom description? S/N")
            val option = reading.nextLine()
            if (option.equals("S", true)) {
                println("Enter your custom description for the game:")
                val customDescription = reading.nextLine()
                myGame.description = customDescription
            } else {
                myGame.description = myGame.title
            }

            gamer.searchGames.add(myGame)
        }

        println("Want to look for a new game? Y/N")
        response = reading.nextLine()

    } while (response.equals("Y", true))

    println("Games searched:")
    println(gamer.searchGames)

    println("Search completed successfully")
}

