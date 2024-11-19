package kr.cosine.joinandquitmessage.config

import com.velocitypowered.api.proxy.Player
import kr.cosine.joinandquitmessage.enums.MessageType
import kr.hqservice.framework.global.core.component.Bean
import kr.hqservice.framework.velocity.core.extension.colorize
import kr.hqservice.framework.yaml.config.HQYamlConfiguration
import net.kyori.adventure.text.Component

@Bean
class SettingConfig(
    config: HQYamlConfiguration
) : AbstractSettingConfig(config) {
    override fun colorize(text: String): String {
        return text.colorize()
    }

    fun getFormattedMessage(messageType: MessageType, player: Player): Component? {
        return getFormattedMessage(messageType, player.username, player.username)?.run(Component::text)
    }
}