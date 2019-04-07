import org.gradle.api.tasks.testing.logging.TestLogEvent.*

plugins {
  idea
  base
  java
  scala
  id("com.github.johnrengelman.shadow") version "5.0.0"
}

tasks.withType<Wrapper> {
  val gradleWrapperVersion: String by project
  gradleVersion = gradleWrapperVersion
}

val junitJupiterVersion: String by project
val javaVersion = JavaVersion.VERSION_1_8

java {
  sourceCompatibility = javaVersion
  targetCompatibility = javaVersion
}

sourceSets {
  main {
    java.srcDir("src/main/scala")
  }
  test {
    java.srcDir("src/test/scala")
  }
}

repositories {
  mavenCentral()
  gradlePluginPortal()
  maven(url = "https://repo.spring.io/snapshot")
  maven(url = "https://repo.spring.io/milestone")
}

dependencies {
  val scalaVersion: String by project
  implementation("org.scala-lang:scala-library:$scalaVersion")

  val scalaMajorVersion: String by project
  val scalaMeterVersion: String by project
  implementation("com.storm-enroute:scalameter-core_$scalaMajorVersion:$scalaMeterVersion")
}

tasks.withType<Jar> {
  manifest {
    val mainClass: String by project
    attributes(
        "Main-Class" to mainClass
    )
  }
}

tasks.withType<Test> {
  useJUnitPlatform()
  testLogging {
    showExceptions = true
    showStandardStreams = true
    events(PASSED, SKIPPED, FAILED)
  }
}

defaultTasks("clean", "shadowJar")
