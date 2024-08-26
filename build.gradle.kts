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
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    manifest {
        attributes (
            "Premain-Class" to "moe.kurenai.demo.HelperAgent"
        )
    }
    from(configurations.runtimeClasspath.get().map { if (it.isDirectory()) it else zipTree(it) })
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}
