package br.com.dimensao.gabgames.services

import br.com.dimensao.gabgames.model.Gamer
import br.com.dimensao.gabgames.model.InfoGame
import br.com.dimensao.gabgames.model.InfoGamerJson
import br.com.dimensao.gabgames.utils.createGamer
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
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

    fun searchGamers(): List<Gamer> {
        val address = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"

        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(address))
            .build()
        val response = client
            .send(request, BodyHandlers.ofString())

        val json = response.body()

        val gson = Gson()
        val myGamerType = object : TypeToken<List<InfoGamerJson>>() {}.type
        val gamerList: List<InfoGamerJson> = gson.fromJson(json, myGamerType)

        val newList = gamerList.map { infoGamerJson -> infoGamerJson.createGamer()}

        return newList
    }
}