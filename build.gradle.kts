plugins {
    kotlin("jvm") version "1.4.0"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()

}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("com.jessecorbett:diskord:1.7.3")
    implementation("com.jessecorbett:diskord-jvm:1.7.3")

    implementation("com.bernardomg.tabletop:dice:2.0.1")
    implementation("org.slf4j:slf4j-simple:1.6.1")
    //testImplementation("junit", "junit", "4.12")
}

application{
    mainClassName = "com.stewsters.rpgbot.BotKt"
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}