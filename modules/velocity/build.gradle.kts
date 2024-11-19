plugins {
    kotlin("kapt")
}

dependencies {
    compileOnly("com.velocitypowered", "velocity-api", "3.3.0-SNAPSHOT")
    compileOnly("kr.hqservice", "hqframework-proxy-velocity-core", "1.0.2-SNAPSHOT")
    kapt("com.velocitypowered", "velocity-api", "3.3.0-SNAPSHOT")
}