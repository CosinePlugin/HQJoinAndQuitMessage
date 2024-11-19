package kr.cosine.joinandquitmessage.config

import kr.cosine.joinandquitmessage.enums.MessageType
import kr.hqservice.framework.bukkit.core.extension.colorize
import kr.hqservice.framework.global.core.component.Bean
import kr.hqservice.framework.yaml.config.HQYamlConfiguration
import org.bukkit.entity.Player

@Bean
class SettingConfig(
    config: HQYamlConfiguration
) : AbstractSettingConfig(config) {
    override fun colorize(text: String): String {
        return text.colorize()
    }

    fun getFormattedMessage(messageType: MessageType, player: Player): String? {
        return getFormattedMessage(messageType, player.name, player.displayName)
    }
}