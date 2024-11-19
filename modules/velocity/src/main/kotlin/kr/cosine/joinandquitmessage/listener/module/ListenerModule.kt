package kr.cosine.joinandquitmessage.listener.module

import kr.cosine.joinandquitmessage.listener.JoinAndQuitListener
import kr.hqservice.framework.global.core.component.Component
import kr.hqservice.framework.global.core.component.HQModule
import kr.hqservice.framework.velocity.core.HQVelocityPlugin

@Component
class ListenerModule(
    private val plugin: HQVelocityPlugin,
    private val joinAndQuitListener: JoinAndQuitListener
) : HQModule {
    override fun onEnable() {
        plugin.getEventManager().register(plugin, joinAndQuitListener)
    }
}