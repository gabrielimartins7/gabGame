package br.com.dimensao.gabgames.utils

import br.com.dimensao.gabgames.model.Gamer
import br.com.dimensao.gabgames.model.InfoGamerJson

fun InfoGamerJson.createGamer(): Gamer {
    return Gamer(this.name, this.email, this.dataBirth, this.user)

}