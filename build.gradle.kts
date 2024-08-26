plugins {
    kotlin("jvm") version "2.0.0"
}

group = "moe.kurenai.demo"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("net.bytebuddy:byte-buddy:1.15.0")
    implementation("net.bytebuddy:byte-buddy-agent:1.15.0")

    testImplementation(kotlin("test"))
}

tasks.jar {
    manifest {
        attributes (
            "Premain-Class" to "HelperAgent"
        )
    }
    from(configurations.runtimeClasspath)
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}
