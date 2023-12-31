import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
  kotlin("multiplatform")
  id("org.jetbrains.compose")
}

group = "com.example"
version = "1.0-SNAPSHOT"

repositories {
  google()
  maven("https://maven.aliyun.com/repository/public/")
  mavenCentral()
  maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

kotlin {
  jvm {
    jvmToolchain(11)
    withJava()
  }
  sourceSets {
    val jvmMain by getting {
      dependencies {
        implementation(compose.desktop.currentOs) {
          exclude("org.jetbrains.kotlin.compose.material")
        }
        implementation("org.jetbrains.compose.material3:material3-desktop:1.4.0")
      }
    }
    val jvmTest by getting
  }
}

compose.desktop {
  application {
    mainClass = "MainKt"
    nativeDistributions {
      targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
      packageName = "pokelab-desktop"
      packageVersion = "1.0.0"
    }
  }
}
