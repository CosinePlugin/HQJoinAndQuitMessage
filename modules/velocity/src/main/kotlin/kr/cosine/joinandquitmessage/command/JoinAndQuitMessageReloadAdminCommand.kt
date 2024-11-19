package kr.cosine.joinandquitmessage.command

import com.velocitypowered.api.command.RawCommand
import kr.cosine.joinandquitmessage.config.SettingConfig
import kr.hqservice.framework.global.core.component.Bean
import net.kyori.adventure.text.Component

@Bean
class JoinAndQuitMessageReloadAdminCommand(
    private val settingConfig: SettingConfig
) : RawCommand {
    override fun execute(invocation: RawCommand.Invocation) {
        invocation.source().sendMessage(Component.text("§aconfig.yml을 리로드하였습니다."))
        settingConfig.reload()
    }

    override fun hasPermission(invocation: RawCommand.Invocation): Boolean {
        return invocation.source().hasPermission("op")
    }

    override fun suggest(invocation: RawCommand.Invocation): List<String> {
        return emptyList()
    }
}