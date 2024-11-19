package kr.cosine.joinandquitmessage.command.module

import kr.cosine.joinandquitmessage.command.JoinAndQuitMessageReloadAdminCommand
import kr.hqservice.framework.bungee.core.HQBungeePlugin
import kr.hqservice.framework.global.core.component.Component
import kr.hqservice.framework.global.core.component.HQModule

@Component
class CommandModule(
    private val plugin: HQBungeePlugin,
    private val joinAndQuitMessageReloadAdminCommand: JoinAndQuitMessageReloadAdminCommand
) : HQModule {
    override fun onEnable() {
        plugin.proxy.pluginManager.registerCommand(plugin, joinAndQuitMessageReloadAdminCommand)
    }
}