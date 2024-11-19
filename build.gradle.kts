plugins {
    kotlin("jvm") version "1.7.21"
    id("com.github.johnrengelman.shadow") version "8.1.1"
    kotlin("kapt") version "1.7.21" apply false
}

allprojects {
    group = "kr.cosine.joinandquitmessage"
    version = "1.0.0"

    repositories {
        maven("https://maven.hqservice.kr/repository/maven-public/")
        maven("https://repo.papermc.io/repository/maven-public/")
    }
}

subprojects {
    val subProjectName = name
    val buildableProject = subProjectName.contains(Regex("bukkit|bungee|velocity"))

    apply {
        plugin("org.jetbrains.kotlin.jvm")
        plugin("com.github.johnrengelman.shadow")
    }

    dependencies {
        compileOnly("org.jetbrains.kotlin", "kotlin-stdlib-jdk8")
        compileOnly("kr.hqservice", "hqframework-global-core", "1.0.2-SNAPSHOT")

        testImplementation(kotlin("test"))
    }

    if (buildableProject) {
        dependencies {
            api(project(":modules:core"))
        }
        tasks.shadowJar {
            archiveFileName.set("${rootProject.name}-$subProjectName-${rootProject.version}.jar")
            destinationDirectory.set(file(rootProject.projectDir.path + "/build_output"))
        }
    }

    tasks {
        test {
            useJUnitPlatform()
        }
        build {
            dependsOn(shadowJar)
        }
    }
}