plugins {
    kotlin("js") version "1.5.21"
}

group = "me.rahim"
version = "1.0-SNAPSHOT"

repositories {
    jcenter()
    mavenCentral()
}

dependencies {
    val doodleVersion = "0.5.2" // <--- Latest Doodle version

    dependencies {
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.1")
        implementation ("io.nacular.doodle:core:$doodleVersion")
        implementation ("io.nacular.doodle:browser:$doodleVersion")
        implementation(npm("stellar-sdk","8.2.5"))
        implementation(npm("@albedo-link/intent","^0.11.2"))
        // Optional
        // implementation ("io.nacular.doodle:controls:$doodleVersion")
        // implementation ("io.nacular.doodle:animation:$doodleVersion")
        // implementation ("io.nacular.doodle:themes:$doodleVersion")
    }
    testImplementation(kotlin("test"))
}

kotlin {
    js(LEGACY) {
        binaries.executable()
        browser {
            commonWebpackConfig {
                cssSupport.enabled = true
            }
        }
    }
}