package kr.cosine.joinandquitmessage.command

import kr.cosine.joinandquitmessage.config.SettingConfig
import kr.hqservice.framework.global.core.component.Bean
import net.md_5.bungee.api.CommandSender
import net.md_5.bungee.api.chat.TextComponent
import net.md_5.bungee.api.plugin.Command
import net.md_5.bungee.api.plugin.TabExecutor

@Bean
class JoinAndQuitMessageReloadAdminCommand(
    private val settingConfig: SettingConfig
) : Command("프록시입퇴장메시지리로드", "op"), TabExecutor {
    override fun execute(sender: CommandSender, args: Array<out String>) {
        settingConfig.reload()
        sender.sendMessage(TextComponent("§aconfig.yml을 리로드하였습니다."))
    }

    override fun onTabComplete(sender: CommandSender, args: Array<out String>): List<String> {
        return emptyList()
    }
}