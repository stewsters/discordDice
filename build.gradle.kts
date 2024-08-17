plugins {
    kotlin("jvm") version "2.0.0"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("com.jessecorbett:diskord-bot:5.4.1")
    implementation ("dev.diceroll:dice-parser:0.3.0")
}

application {
    mainClass = "com.stewsters.rpgbot.BotKt"
}