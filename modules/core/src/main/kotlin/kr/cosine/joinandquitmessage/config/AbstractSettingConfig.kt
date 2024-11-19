package kr.cosine.joinandquitmessage.config

import kr.cosine.joinandquitmessage.enums.MessageType
import kr.hqservice.framework.yaml.config.HQYamlConfiguration

abstract class AbstractSettingConfig(
    private val config: HQYamlConfiguration
) {
    private val isEnabled get() = config.getBoolean("message.enabled")

    fun load() {
        val joinMessage = colorize(config.getString("message.join"))
        val quitMessage = colorize(config.getString("message.quit"))
        MessageType.JOIN.setMessage(joinMessage)
        MessageType.QUIT.setMessage(quitMessage)
    }

    fun reload() {
        config.reload()
        load()
    }

    abstract fun colorize(text: String): String

    fun getFormattedMessage(messageType: MessageType, name: String, displayName: String): String? {
        return messageType.getMessage {
            it.replace("%player%", name)
                .replace("%player_display%", displayName)
        }.takeIf { isEnabled }
    }
}