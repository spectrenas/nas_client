buildscript {
    extra.set("kotlin_version","1.7.10")
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${rootProject.extra["kotlin_version"]}")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

val output: Provider<Directory> = rootProject.layout.buildDirectory.dir("../../build")
rootProject.layout.buildDirectory.set(output.get())
subprojects {
    val subOutput = project.layout.buildDirectory.dir("${output.get().asFile}/${project.name}")
    project.layout.buildDirectory.set(subOutput.get())
}

subprojects {
    project.evaluationDependsOn(":app")
}

tasks.register<Delete>("clean") {
    delete(output)
}