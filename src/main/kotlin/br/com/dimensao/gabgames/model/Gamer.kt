package br.com.dimensao.gabgames.model

import java.util.Scanner
import kotlin.random.Random

data class Gamer(var name:String, var email:String) {
    var birth:String? = null
    var user:String? = null
        set(value) {
            field = value
            if (idName.isNullOrBlank()){
                createIdName()
            }
        }
    var idName:String? = null
        private set
    val searchGames = mutableListOf<Game?>()

    constructor(name: String, email: String, birth:String, user:String):
            this( name, email) {
                this.birth = birth
                this.user = user
                createIdName()
            }

    init {
        if (name.isNullOrBlank()) {
            throw IllegalArgumentException("Name is blank")
        }
        this.email = validateEmail()
    }

    override fun toString(): String {
        return "Gamer(name='$name', email='$email', birth=$birth, user=$user, idName=$idName)"
    }

    fun createIdName() {
        val number = Random.nextInt(10000)
        val tag = String.format("%04d", number)

        idName = "$user#$tag"
    }

    fun validateEmail(): String {
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        if (regex.matches(email)) {
            return email
        } else {
            throw IllegalArgumentException("Invalid email")
        }
    }

    fun rentGame(game: Game): rent {
        return rent(this, game)
    }

    companion object {
        fun createGamer(reading: Scanner): Gamer{
            println("Welcome to GabGames! Let's register you. Enter your name:")
            val name = reading.nextLine()
            println("Enter your email:")
            val email = reading.nextLine()
            println("Do you want to complete your registration with username and date of birth? (Y/N)")
            val option = reading.nextLine()

            if(option.equals("s", true)) {
                println("Enter your date of birth (DD/MM/YYYY):")
                val birth = reading.nextLine()
                println("Enter your username:")
                val user = reading.nextLine()

                return Gamer(name, email, birth, user)
            } else {
                return Gamer(name, email)
            }
        }
    }
}
