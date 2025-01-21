plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.practice.gradlesexperiments"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.practice.gradlesexperiments"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    flavorDimensions += "default"
    productFlavors {
        create("stagging") {
            dimension = "default"
            buildConfigField("String", "BASE_URL", "\"https://www.example_test.com/\"")
            buildConfigField("String", "LOGIN_API", "\"https://www.example_test.com/login\"")
            buildConfigField("String", "PROFILE_API", "\"https://www.example_test.com/profile\"")
        }

        create("production") {
            dimension = "default"
            buildConfigField("String", "BASE_URL", "\"https://www.example_live.com/\"")
            buildConfigField("String", "LOGIN_API", "\"https://www.example_live.com/login\"")
            buildConfigField("String", "PROFILE_API", "\"https://www.example_live.com/profile\"")
        }
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
            isDebuggable = true
        }

        release {
            isMinifyEnabled = true
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        buildConfig = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}