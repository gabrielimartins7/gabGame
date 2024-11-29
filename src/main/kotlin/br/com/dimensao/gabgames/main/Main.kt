package br.com.dimensao.gabgames.main

import br.com.dimensao.gabgames.model.Game
import br.com.dimensao.gabgames.services.Api
import java.util.Scanner


fun main() {
    val reading = Scanner(System.`in`)
    println("Enter a game code to search: ")

    val search = reading.nextLine()

    val searchApi = Api()
    val infoGame = searchApi.searchGame(search)

    val myGame: Game? = null

    val result = runCatching {
        val myGame = Game(
            infoGame.info.title,
            infoGame.info.thumb
        )
    }

    result.onFailure {
        println("Nonexistent game. Try another id")
    }
    result.onSuccess {
        println("Want to enter a custom description? S/N")
        val option = reading.nextLine()
        if(option.equals("S", true)) {
            println("Enter your custom description for the game:")
            val custonDescription = reading.nextLine()
            myGame?.description = custonDescription
        } else {
            myGame?.description = myGame?.title
        }

        println(myGame)
    }

    result.onSuccess {
        println("Search completed successfully")
    }
}