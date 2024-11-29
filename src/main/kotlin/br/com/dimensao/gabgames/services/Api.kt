package br.com.dimensao.gabgames.services

import br.com.dimensao.gabgames.model.InfoGame
import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers

class Api {
    fun searchGame(id: String):InfoGame {
        val address = "https://www.cheapshark.com/api/1.0/games?id=$id"

        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(address))
            .build()
        val response = client
            .send(request, BodyHandlers.ofString())

        val json = response.body()

        val gson = Gson()
        val infoMyGame = gson.fromJson(json, InfoGame::class.java)

        return infoMyGame
    }
}