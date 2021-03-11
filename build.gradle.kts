plugins {
    java
    kotlin("jvm") version "1.4.21"
    id("com.github.johnrengelman.shadow") version "6.1.0"

    kotlin("plugin.serialization") version "1.4.21"
}

group = "tv.banko"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots")
}

dependencies {
    compileOnly("org.spigotmc", "spigot-api", "1.16.5-R0.1-SNAPSHOT")
}

java.sourceCompatibility = JavaVersion.VERSION_11
java.targetCompatibility = JavaVersion.VERSION_11