package br.com.dimensao.gabgames.main

import br.com.dimensao.gabgames.services.Api

fun main() {
    val consumption = Api()
    val gamersList = consumption.searchGamers()

    println(gamersList)
}