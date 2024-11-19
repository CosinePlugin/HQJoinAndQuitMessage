package kr.cosine.joinandquitmessage.command.module

import kr.cosine.joinandquitmessage.command.JoinAndQuitMessageReloadAdminCommand
import kr.hqservice.framework.bukkit.core.HQBukkitPlugin
import kr.hqservice.framework.bukkit.core.component.module.Module
import kr.hqservice.framework.bukkit.core.component.module.Setup

@Module
class CommandModule(
    private val plugin: HQBukkitPlugin,
    private val joinAndQuitMessageReloadAdminCommand: JoinAndQuitMessageReloadAdminCommand
) {
    @Setup
    fun setup() {
        plugin.getCommand("버킷입퇴장메시지리로드")?.setExecutor(joinAndQuitMessageReloadAdminCommand)
    }
}