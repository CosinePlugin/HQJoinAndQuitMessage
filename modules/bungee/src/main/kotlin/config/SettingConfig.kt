package kr.cosine.joinandquitmessage.config

import kr.cosine.joinandquitmessage.enums.MessageType
import kr.hqservice.framework.bungee.core.extension.colorize
import kr.hqservice.framework.global.core.component.Bean
import kr.hqservice.framework.yaml.config.HQYamlConfiguration
import net.md_5.bungee.api.chat.TextComponent
import net.md_5.bungee.api.connection.ProxiedPlayer

@Bean
class SettingConfig(
    config: HQYamlConfiguration
) : AbstractSettingConfig(config) {
    override fun colorize(text: String): String {
        return text.colorize()
    }

    fun getFormattedMessage(messageType: MessageType, player: ProxiedPlayer): TextComponent? {
        return getFormattedMessage(messageType, player.name, player.displayName)?.run(::TextComponent)
    }
}