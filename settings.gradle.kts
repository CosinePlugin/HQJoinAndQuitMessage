plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "HQJoinAndQuitMessage"

includeModules()

fun includeModules() {
    file("${rootProject.projectDir.path}/modules").listFiles()?.forEach { path ->
        if (path.name == "build") return@forEach
        include("modules:${path.name}")
    }
}
include("modules:bungee")
findProject(":modules:bungee")?.name = "bungee"
include("modules:velocity")
findProject(":modules:velocity")?.name = "velocity"
