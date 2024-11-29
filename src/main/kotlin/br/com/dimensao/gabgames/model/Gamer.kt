package br.com.dimensao.gabgames.model

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

    constructor(name: String, email: String, birth:String, user:String):
            this( name, email) {
                this.birth = birth
                this.user = user
                createIdName()
            }

    override fun toString(): String {
        return "Gamer(name='$name', email='$email', birth=$birth, user=$user, idName=$idName)"
    }

    fun createIdName() {
        val number = Random.nextInt(10000)
        val tag = String.format("%04d", number)

        idName = "$user#$tag"
    }
}
