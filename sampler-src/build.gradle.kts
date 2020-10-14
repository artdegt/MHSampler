plugins {
    //kotlin("jvm").version("1.3.61")
    kotlin("jvm")
}

repositories {
    mavenCentral()
    jcenter()
    maven("https://dl.bintray.com/mipt-npm/dataforge")
    maven("https://dl.bintray.com/mipt-npm/scientifik")
    maven("https://dl.bintray.com/kotlin/ktor/")
    maven("https://dl.bintray.com/mipt-npm/dev")
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("scientifik:plotlykt-server:0.1.2")
    //implementation("scientifik:kmath-core:0.1.3")
    implementation("scientifik:kmath-prob-jvm:0.1.4-dev-4")
    //{exclude(module = "src:main:kotlin:sampler")}
    //implementation(project(":src"))
}