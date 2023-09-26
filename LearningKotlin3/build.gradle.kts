plugins {
    kotlin("jvm") version "1.8.21"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.codehaus.groovy:groovy-all:2.4.21")
    implementation(kotlin("stdlib-jdk8"))
    testImplementation("org.jetbrains.kotlin", "kotlin-test-junit5", "1.3.72")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(11)
}