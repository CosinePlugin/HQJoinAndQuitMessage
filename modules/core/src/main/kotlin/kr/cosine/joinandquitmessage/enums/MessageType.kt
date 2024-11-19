package kr.cosine.joinandquitmessage.enums

enum class MessageType(
    private var message: String = ""
) {
    JOIN,
    QUIT;

    fun getMessage(replace: (String) -> String): String {
        return replace(message)
    }

    fun setMessage(message: String) {
        this.message = message
    }

    companion object {
        fun of(text: String): MessageType? {
            return runCatching { valueOf(text.uppercase()) }.getOrNull()
        }
    }
}