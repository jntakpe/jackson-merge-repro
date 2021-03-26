import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.31"
}

group = "com.github.jntakpe"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.12.1")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.4.0")
    testImplementation("org.assertj:assertj-core:3.11.1")
    testRuntime("org.junit.jupiter:junit-jupiter-engine:5.4.0")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.withType<Test> {
    useJUnitPlatform()
}
