package kr.cosine.joinandquitmessage.listener

import com.velocitypowered.api.event.PostOrder
import com.velocitypowered.api.event.Subscribe
import com.velocitypowered.api.event.connection.DisconnectEvent
import com.velocitypowered.api.event.player.ServerConnectedEvent
import com.velocitypowered.api.proxy.Player
import com.velocitypowered.api.proxy.ProxyServer
import kr.cosine.joinandquitmessage.config.SettingConfig
import kr.cosine.joinandquitmessage.enums.MessageType
import kr.hqservice.framework.global.core.component.Bean

@Bean
class JoinAndQuitListener(
    private val proxyServer: ProxyServer,
    private val settingConfig: SettingConfig
) {
    @Subscribe(order = PostOrder.LAST)
    fun onServerConnected(event: ServerConnectedEvent) {
        if (event.previousServer.isEmpty) {
            broadcast(MessageType.JOIN, event.player)
        }
    }

    @Subscribe(order = PostOrder.LAST)
    fun onServerDisconnect(event: DisconnectEvent) {
        broadcast(MessageType.QUIT, event.player)
    }

    private fun broadcast(messageType: MessageType, player: Player) {
        val message = settingConfig.getFormattedMessage(messageType, player)
        if (message != null) {
            proxyServer.sendMessage(message)
        }
    }
}