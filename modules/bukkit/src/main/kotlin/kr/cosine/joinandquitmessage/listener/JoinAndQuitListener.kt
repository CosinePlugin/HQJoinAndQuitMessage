package kr.cosine.joinandquitmessage.listener

import kr.cosine.joinandquitmessage.config.SettingConfig
import kr.cosine.joinandquitmessage.enums.MessageType
import kr.hqservice.framework.bukkit.core.listener.HandleOrder
import kr.hqservice.framework.bukkit.core.listener.Listener
import kr.hqservice.framework.bukkit.core.listener.Subscribe
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent

@Listener
class JoinAndQuitListener(
    private val settingConfig: SettingConfig
) {
    @Subscribe(HandleOrder.LAST)
    fun onPlayerJoin(event: PlayerJoinEvent) {
        event.joinMessage = settingConfig.getFormattedMessage(MessageType.JOIN, event.player)
    }

    @Subscribe(HandleOrder.LAST)
    fun onPlayerQuit(event: PlayerQuitEvent) {
        event.quitMessage = settingConfig.getFormattedMessage(MessageType.QUIT, event.player)
    }
}