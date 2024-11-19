package kr.cosine.joinandquitmessage

import com.google.inject.Inject
import com.velocitypowered.api.event.EventManager
import com.velocitypowered.api.plugin.Dependency
import com.velocitypowered.api.plugin.Plugin
import com.velocitypowered.api.plugin.PluginContainer
import com.velocitypowered.api.plugin.annotation.DataDirectory
import com.velocitypowered.api.proxy.ProxyServer
import kr.hqservice.framework.velocity.core.HQVelocityPlugin
import org.slf4j.Logger
import java.io.File
import java.nio.file.Path

@Plugin(
    id = "hqjoinandquitmessage",
    name = "HQJoinAndQuitMessage",
    version = "1.0.0",
    authors = ["Cosine_A"],
    dependencies = [Dependency(id = "hqframework")]
)
class HQJoinAndQuitMessage @Inject constructor(
    private val proxyServer: ProxyServer,
    private val pluginContainer: PluginContainer,
    private val logger: Logger,
    private val eventManager: EventManager,
    @DataDirectory private val dataFolder: Path
) : HQVelocityPlugin() {
    override fun getDataFolder(): File {
        return dataFolder.toFile()
    }

    override fun getEventManager(): EventManager {
        return eventManager
    }

    override fun getPluginContainer(): PluginContainer {
        return pluginContainer
    }

    override fun getProxyServer(): ProxyServer {
        return proxyServer
    }

    override fun getSlf4jLogger(): Logger {
        return logger
    }
}