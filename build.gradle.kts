import org.gradle.api.tasks.testing.logging.TestLogEvent.*

plugins {
  idea
  scala
  id("com.github.johnrengelman.shadow") version "5.0.0"
}

tasks.withType<Wrapper> {
  val gradleWrapperVersion: String by project
  gradleVersion = gradleWrapperVersion
}

java {
  val javaVersion = JavaVersion.VERSION_1_8
  sourceCompatibility = javaVersion
  targetCompatibility = javaVersion
}

repositories {
  mavenCentral()
}

val scalaVersion: String by project
val scalaMajorVersion: String by project
val scalaMeterVersion: String by project
val junitVersion: String by project
val scalatestVersion: String by project

dependencies {
  implementation("org.scala-lang:scala-library:$scalaVersion")
  implementation("com.storm-enroute:scalameter-core_$scalaMajorVersion:$scalaMeterVersion")
  testImplementation("org.scalatest:scalatest_$scalaMajorVersion:$scalatestVersion")
  testImplementation("junit:junit:$junitVersion")
}

tasks.withType<Jar> {
  manifest {
    val mainClass: String by project
    attributes("Main-Class" to mainClass)
  }
}

tasks.withType<Test> {
  useJUnit()
  testLogging {
    showExceptions = true
    showStandardStreams = true
    events(PASSED, SKIPPED, FAILED)
  }
}

defaultTasks("clean", "shadowJar", "build")
