plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.google.gms.google.services)
    alias(libs.plugins.google.firebase.crashlytics)
}

android {
    namespace = "com.example.bus"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.bus"
        minSdk = 29
        targetSdk = 35
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
        debug {
            // Enable debugging tools for the debug build
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    // Firebase platform for unified versioning
    implementation(platform(libs.firebase.bom))
    implementation (libs.androidx.room.runtime)
    annotationProcessor (libs.androidx.room.compiler)
    // Firebase services
    implementation(libs.firebase.auth)
    implementation(libs.firebase.firestore.ktx)
    implementation(libs.firebase.database)
    implementation(libs.play.services.auth)
    implementation (libs.play.services.auth.v2050)
    // AndroidX Libraries

    implementation (libs.firebase.core)
    implementation (libs.firebase.firestore.v2460)
    implementation (libs.firebase.crashlytics.v1837)


    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    implementation(libs.lifecycle.livedata.ktx)
    implementation(libs.lifecycle.viewmodel.ktx)
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)
    implementation(libs.activity.ktx)
    implementation(libs.activity.ktx.v182)
    implementation (libs.firebase.firestore.v2412)

    // Lottie for animations
    implementation(libs.lottie)
    implementation(libs.lottie.compose)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation (libs.androidx.cardview)



}
