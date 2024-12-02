plugins {
    kotlin("jvm") version "2.1.0"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    testImplementation(kotlin("test"))

    testImplementation(group = "org.junit.jupiter", name ="junit-jupiter-api", version = "5.8.1")
    testRuntimeOnly(group = "org.junit.jupiter", name = "junit-jupiter-engine", version = "5.8.1")
}

sourceSets {
    test {
        kotlin {
            srcDirs("./day1/tests", "./day2/tests",)
        }
    }
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("MainKt")
}