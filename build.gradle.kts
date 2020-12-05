plugins {
    kotlin("jvm") version "1.4.20"
    application
}

tasks.test {
    useJUnitPlatform()
}

application {
    mainClass.set("com.jackchapman.adventofcode.AdventOfCodeKt")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.7.0")
}
