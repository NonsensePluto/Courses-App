plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)

    alias(libs.plugins.kotlinKapt)
}

android {
    namespace = "com.example.coursesapp.data"
    compileSdk = 36

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)

    //Domain
    implementation(project(":domain"))

    // Retrofit
    implementation(libs.retrofit2)
    implementation(libs.retrofit2GsonConverter)

    //OkHttp
    implementation(libs.okhttp3)
    implementation(libs.okhttp3Logging)

    //Coroutines
    implementation(libs.coroutinesCore)
    implementation(libs.coroutinesAndroid)

    //Coroutine Lifecycle Scopes
    implementation(libs.lifecycleViewModel)

    //Room
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    kapt(libs.androidx.room.compiler)
}
kapt {
    correctErrorTypes = true
}