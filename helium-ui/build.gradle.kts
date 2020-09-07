plugins {
    id("com.android.library")
    kotlin("android")
}

androidLib()

dependencies {
    testImplementation(project(":helium-test"))
    implementation(project(":helium-core"))
    Deps.androidXUiDeps.forEach(::api)
}

apply("../maven-push.gradle")
