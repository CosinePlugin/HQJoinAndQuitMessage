package kr.cosine.joinandquitmessage.config.module

import kr.cosine.joinandquitmessage.config.SettingConfig
import kr.hqservice.framework.global.core.component.Component
import kr.hqservice.framework.global.core.component.HQModule

@Component
class ConfigModule(
    private val settingConfig: SettingConfig
) : HQModule {
    override fun onEnable() {
        settingConfig.load()
    }
}