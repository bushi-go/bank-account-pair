/*
 * This file was generated by the Gradle 'init' task.
 *
 * The settings file is used to specify which projects to include in your build.
 * For more detailed information on multi-project builds, please refer to https://docs.gradle.org/8.5/userguide/building_swift_projects.html in the Gradle documentation.
 * This project uses @Incubating APIs which are subject to change.
 */

pluginManagement {
    // Include 'plugins build' to define convention plugins.
    includeBuild("build-logic")
}

plugins {
    // Apply the foojay-resolver plugin to allow automatic download of JDKs
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.7.0"
}

rootProject.name = "java-microservice-template"

include(
    // Appliction packages
    // Those packages contains the code of the various applications you can need
    "application:rest:contract",
    "application:rest:executable",
    "application:grpc:contract",
    "application:grpc:executable",
    "application:consumer:contract",
    "application:consumer:executable",
    "application:cli:executable",
    // Domain packages
    // Those packages contains the code of the core of your application, embedding the business logic
    "domain:contract",
    "domain:core",
    "domain:mediator",
    // Infrastructure packages
    // Those packages contains the code of the infrastructure of your application, like configuration, the database, async publishers, rest or grpc clients.
    "infrastructure:clients",
    "infrastructure:configuration",
    "infrastructure:events",
    "infrastructure:persistence"
)