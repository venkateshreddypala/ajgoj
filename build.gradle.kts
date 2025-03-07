plugins {
    scala
    java
    id("com.github.maiflai.scalatest") version "0.32" // For ScalaTest integration
    id("com.github.johnrengelman.shadow") version "8.1.1" // For fat JAR creation
}

repositories {
    mavenCentral()
}

val scala3Version = "3.3.1" // Latest stable Scala 3 version as of March 2025
val javaVersion = JavaVersion.VERSION_21 // Latest LTS Java version

dependencies {
    // Scala 3
    implementation("org.scala-lang:scala3-library_3:$scala3Version")

    // Testing - JUnit 5 (latest version)
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.1")

    // ScalaTest for Scala 3
    testImplementation("org.scalatest:scalatest_3:3.2.17")
    testImplementation("org.scalatestplus:junit-5-10_3:3.2.17.0")
    testRuntimeOnly("com.vladsch.flexmark:flexmark-all:0.64.8") // Required by ScalaTest for HTML reports
}

// SBT integration task
tasks.register<Exec>("sbtCompile") {
    description = "Runs SBT compile task"
    commandLine("sbt", "compile")
}

tasks.register<Exec>("sbtTest") {
    description = "Runs SBT test task"
    commandLine("sbt", "test")
}

tasks.register<Exec>("sbtConsole") {
    description = "Starts the Scala REPL with project classes"
    commandLine("sbt", "console")
}

// Linking Gradle and SBT tasks
tasks.named("compileScala") {
    dependsOn("sbtCompile")
}

// Fix for useJUnitPlatform() error
tasks.withType<Test> {
    useJUnitPlatform()
}

// Configure Scala compilation
tasks.withType<ScalaCompile> {
    scalaCompileOptions.apply {
        // For Scala 3, we need to use appropriate flags
        additionalParameters = listOf("-feature", "-deprecation", "-new-syntax")
    }
}

// Java compatibility
java {
    sourceCompatibility = javaVersion
    targetCompatibility = javaVersion
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(javaVersion.majorVersion))
    }
}

// Create a task to generate a simple build.sbt file
tasks.register("generateSbt") {
    description = "Generates a simple build.sbt file for SBT integration"

    doLast {
        file("build.sbt").writeText("""
            scalaVersion := "$scala3Version"
            
            libraryDependencies ++= Seq(
              "org.scala-lang" %% "scala3-library" % "$scala3Version",
              "org.scalatest" %% "scalatest" % "3.2.17" % Test
            )
        """.trimIndent())

        file("project").mkdirs()
        file("project/build.properties").writeText("sbt.version=1.9.7")
    }
}

// Run generateSbt task during project setup
tasks.named("processResources") {
    dependsOn("generateSbt")
}