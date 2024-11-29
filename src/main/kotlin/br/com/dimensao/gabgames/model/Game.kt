package br.com.dimensao.gabgames.model

data class Game(
            val title: String,
            val cover: String
) {
    var description:String? = null

    override fun toString(): String {
        return "My br.com.dimensao.gabgames.model.Game:\n" +
                "Title: $title\n" +
                "Cover: $cover\n" +
                "description: $description"
    }
}