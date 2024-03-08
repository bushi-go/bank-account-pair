/*
 * This file was generated by the Gradle 'init' task.
 *
 * This project uses @Incubating APIs which are subject to change.
 */

plugins {
    // Apply the java Plugin to add support for Java.
    java
    id("jacoco")
    id("checkstyle")
    id("maven-publish")

}

repositories {
    mavenLocal()
    // Use Maven Central for resolving dependencies.
    mavenCentral()

}

configure<JavaPluginExtension> {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
    withSourcesJar()
    withJavadocJar()
}

configure<CheckstyleExtension> {
    isIgnoreFailures = false
    isShowViolations = true
}

tasks.named<Checkstyle>("checkstyleMain") {
    reports.xml.outputLocation.set(layout.buildDirectory.file("reports/checkstyle/main.xml").get())
    reports.html.outputLocation.set(layout.buildDirectory.file("reports/checkstyle/main.html").get())
}

tasks.named<Checkstyle>("checkstyleTest") {
    reports.xml.outputLocation.set(layout.buildDirectory.file("reports/checkstyle/test.xml").get())
    reports.html.outputLocation.set(layout.buildDirectory.file("reports/checkstyle/test.html").get())
}

tasks.named<Javadoc>("javadoc") {
    options.encoding = "UTF8"
    // Potentially unsafe but can't be helped (see https://github.com/gradle/gradle/issues/7038)
    (options as StandardJavadocDocletOptions).addStringOption("Xdoclint:none", "-quiet")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.compilerArgs.add("-Werror")
    options.compilerArgs.add("-Xlint:all")
    options.compilerArgs.add("-Xlint:-classfile")
    options.compilerArgs.add("-Xlint:-processing")
    options.compilerArgs.add("-parameters")
}

tasks.withType<Test> {
    useJUnitPlatform()
    finalizedBy("jacocoTestReport")
}

tasks.named<JavaCompile>("compileTestJava") {
    options.encoding = "UTF8"
}


if (project.hasProperty("overrideVersion")) {
    project.version = project.properties["overrideVersion"]!!
} else {
    project.version = "0.0.0-SNAPSHOT"
}
if (project.hasProperty("artifactRepositoryUrl") &&
    project.hasProperty("artifactRepositoryUser") &&
    project.hasProperty("artifactRepositoryToken")
) {
    configure<PublishingExtension> {

        repositories {
            maven {
                name = "project"
                url = uri(project.findProperty("artifactRepositoryUrl").toString())
                credentials {
                    username = project.findProperty("artifactRepositoryUser").toString()
                    password = project.findProperty("artifactRepositoryToken").toString()
                }
                authentication {
                    create("HeaderAuthentication", HttpHeaderAuthentication::class.java)
                }
            }
        }
        publications.create<MavenPublication>("maven") {
            groupId = project.group as String
            artifactId = (project.name).replace("-", ".")
            version = project.version as String

            from(components["java"])
            artifact(tasks["sourcesJar"])
            artifact(tasks["javadocJar"])
            pom.withXml {
                val root = asNode()
                val nodes = root["dependencyManagement"] as groovy.util.NodeList
                if (!nodes.isEmpty()) {
                    root.remove(nodes.first() as groovy.util.Node)
                }
            }
            versionMapping {
                usage("java-api") {
                    fromResolutionResult()
                }
                usage("java-runtime") {
                    fromResolutionResult()
                }
            }
        }
    }
}



dependencies {
    implementation("org.slf4j:slf4j-api:2.0.5")
    compileOnly("org.projectlombok:lombok:1.18.22")
    annotationProcessor("org.projectlombok:lombok:1.18.22")


    testCompileOnly("org.projectlombok:lombok:1.18.22")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.22")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testImplementation("org.assertj:assertj-core:3.25.3")

    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}
