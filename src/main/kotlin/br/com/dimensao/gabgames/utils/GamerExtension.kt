package br.com.dimensao.gabgames.utils

import br.com.dimensao.gabgames.model.Gamer
import br.com.dimensao.gabgames.model.InfoGamerJson



fun InfoGamerJson.createGamer(): Gamer {
    println("Name: $name, Email: $email, Birth: $birth, User: $user")
    return Gamer(this.name, this.email, this.birth, this.user)

}