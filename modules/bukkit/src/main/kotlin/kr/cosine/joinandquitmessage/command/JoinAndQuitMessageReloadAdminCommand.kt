package kr.cosine.joinandquitmessage.command

import kr.cosine.joinandquitmessage.config.SettingConfig
import kr.hqservice.framework.global.core.component.Bean
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter

@Bean
class JoinAndQuitMessageReloadAdminCommand(
    private val settingConfig: SettingConfig
) : CommandExecutor, TabCompleter {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        settingConfig.reload()
        sender.sendMessage("§aconfig.yml을 리로드하였습니다.")
        return true
    }

    override fun onTabComplete(sender: CommandSender, command: Command, label: String, args: Array<out String>): List<String> {
        return emptyList()
    }
}