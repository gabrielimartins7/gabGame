import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers

import com.google.gson.Gson
import java.util.Scanner


fun main() {
    val reading = Scanner(System.`in`)
    println("Enter a game code to search: ")

    val search = reading.nextLine()

    val address = "https://www.cheapshark.com/api/1.0/games?id=$search"

    val client: HttpClient = HttpClient.newHttpClient()
    val request = HttpRequest.newBuilder()
        .uri(URI.create(address))
        .build()
    val response = client
        .send(request, BodyHandlers.ofString())

    val json = response.body()
    println(json)

    val gson = Gson()
    val InfoMyGame = gson.fromJson(json, InfoGame::class.java)

    val myGame = Game(
            InfoMyGame.info.title,
            InfoMyGame.info.thumb
    )

    println(myGame)
}