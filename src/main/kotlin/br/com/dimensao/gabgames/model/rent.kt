package br.com.dimensao.gabgames.model

data class rent(val gamer: Gamer, val game: Game) {
    override fun toString(): String {
        return "Aluguel do ${game.title} por ${gamer.name}"
    }
}
