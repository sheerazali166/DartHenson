plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.darthenson"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.darthenson"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    implementation("com.f2prateek.dart:dart:3.1.3")
    annotationProcessor("com.f2prateek.dart:dart-processor:3.1.2")

    implementation("com.f2prateek.dart:henson:3.1.3")
    annotationProcessor("com.f2prateek.dart:henson-processor:3.1.3")
//    implementation("com.f2prateek.dart:henson-plugin:3.13")
//    annotationProcessor("dart.henson-plugin:3.1.3")

}