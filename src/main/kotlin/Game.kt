import com.google.gson.annotations.SerializedName

class Game(
            @SerializedName("title") val title: String,
            @SerializedName("thumb") val cover: String
) {
    val description = ""

    override fun toString(): String {
        return "My Game:\n" +
                "Title: $title\n" +
                "Cover: $cover\n" +
                "description: $description"
    }
}