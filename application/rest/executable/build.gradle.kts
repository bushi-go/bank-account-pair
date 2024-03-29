/*
 * This file was generated by the Gradle 'init' task.
 *
 * This project uses @Incubating APIs which are subject to change.
 */

plugins {
    id("com.it.example.java-spring-application-conventions")
}

dependencies {

    implementation(project(":application:rest:contract"))
    // Internal modules dependencies
    implementation(project(":domain:core"))

    implementation(project(":application:grpc:contract"))
    implementation(project(":infrastructure:configuration"))
    implementation(project(":infrastructure:persistence"))
    implementation(project(":infrastructure:events"))
    implementation(project(":infrastructure:clients"))
    // https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web
    implementation("org.springframework.boot:spring-boot-starter-web:3.2.1")

    // External dependencies
}
