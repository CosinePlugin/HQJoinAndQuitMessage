package kr.cosine.joinandquitmessage.command.module

import kr.cosine.joinandquitmessage.command.JoinAndQuitMessageReloadAdminCommand
import kr.hqservice.framework.global.core.component.Component
import kr.hqservice.framework.global.core.component.HQModule
import kr.hqservice.framework.velocity.core.HQVelocityPlugin

@Component
class CommandModule(
    private val plugin: HQVelocityPlugin,
    private val joinAndQuitMessageReloadAdminCommand: JoinAndQuitMessageReloadAdminCommand
) : HQModule {
    override fun onEnable() {
        val commandManager = plugin.getProxyServer().commandManager
        val commandMeta = commandManager.metaBuilder("프록시입퇴장메시지리로드")
            .plugin(plugin)
            .build()
        commandManager.register(commandMeta, joinAndQuitMessageReloadAdminCommand)
    }
}