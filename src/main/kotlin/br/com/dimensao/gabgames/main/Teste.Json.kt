package br.com.dimensao.gabgames.main

import br.com.dimensao.gabgames.services.Api

fun main() {
    val consumption = Api()

    val gamersList = consumption.searchGamers()

    val gameId = "10"
    val gameOne = consumption.searchGame(gameId)

    val gamerOne = gamersList.get(3)
    println("Gamer One: $gamerOne")

    println("Game One: $gameOne")
}
