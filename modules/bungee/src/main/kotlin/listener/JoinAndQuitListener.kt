package kr.cosine.joinandquitmessage.listener

import kr.cosine.joinandquitmessage.config.SettingConfig
import kr.cosine.joinandquitmessage.enums.MessageType
import kr.hqservice.framework.bungee.core.component.HQListener
import kr.hqservice.framework.global.core.component.Component
import net.md_5.bungee.api.ProxyServer
import net.md_5.bungee.api.connection.ProxiedPlayer
import net.md_5.bungee.api.event.PlayerDisconnectEvent
import net.md_5.bungee.api.event.PostLoginEvent
import net.md_5.bungee.event.EventHandler
import net.md_5.bungee.event.EventPriority

@Component
class JoinAndQuitListener(
    private val proxyServer: ProxyServer,
    private val settingConfig: SettingConfig
) : HQListener {
    @EventHandler(priority = EventPriority.HIGHEST)
    fun onServerConnected(event: PostLoginEvent) {
        broadcast(MessageType.JOIN, event.player)
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    fun onServerDisconnect(event: PlayerDisconnectEvent) {
        broadcast(MessageType.QUIT, event.player)
    }

    private fun broadcast(messageType: MessageType, player: ProxiedPlayer) {
        val message = settingConfig.getFormattedMessage(messageType, player)
        if (message != null) {
            proxyServer.broadcast(message)
        }
    }
}