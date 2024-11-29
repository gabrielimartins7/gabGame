import br.com.dimensao.gabgames.model.Gamer

fun main() {
    val gamerOne = Gamer(name = "Gabi", email = "gabi@email.com")
    println(gamerOne)

    val gamerTwo = Gamer(
        name = "Gabrieli",
        email = "gabi@email.com",
        birth = "07/09/1998",
        user =  "gabrielimartins7"
    )
    println(gamerTwo)

    gamerOne.let {
        it.birth = "22/11/2000"
        it.user = "gabiuzumaki"
    }.also {
        (gamerOne.idName)
    }

    println(gamerOne)
}