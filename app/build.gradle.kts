plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = 31

    defaultConfig {
        applicationId = "com.android.realtime_coinprices"
        minSdk = 24
        targetSdk = 31
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    packagingOptions {
        resources.excludes.add("META-INF/*")
    }

    buildFeatures {
        compose = true
    }
    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.0-beta04"
    }
}


dependencies {
    implementation(Kotlin.core)
    implementation(Compose.ui)
    implementation(Compose.uiTooling)
    implementation(Compose.livedata)
    implementation(Compose.foundation)
    implementation(Compose.material)
    implementation(Compose.materialIconsCore)
    implementation(Compose.materialIconExtended)
    implementation("com.sinaukoding:cccp:1.0.0")
    implementation(Compose.accompanistPager)
    implementation(Compose.accompanistPagerIndicator)
    androidTestImplementation(Compose.composeUiTest)
    implementation(Compose.navigation)
    implementation(Compose.constraintLayout)

    implementation(Timber.library)
    implementation(Navigation.navigation)
    implementation(Navigation.navigationUI)

    implementation(Kotlin.coroutines)
    implementation(Kotlin.coroutinesCore)
    implementation(Kotlin.coroutineReactive)


    testImplementation(Test.coreTesting)
    testImplementation(Test.coroutineTest)
    testImplementation(Test.turbine)
    testImplementation(Test.mockk)
    testImplementation(Test.extJUnit)
    testImplementation(Test.espressoCore)
    testImplementation(Test.junit)

    // Hilt
    implementation(Hilt.hiltAndroid)
    kapt(Hilt.hiltAndroidCompiler)
    kapt(Hilt.hiltCompiler)
    implementation(Hilt.hiltNavigation)

    //Scarlet socket
    implementation(Socket.scarlet)
    implementation(Socket.scarletGson)
    implementation(Socket.scarletCoroutines)
    implementation(Socket.scarletOkhttp)
    implementation(platform(Socket.okhttpBom))
    implementation(Socket.scarletLifecycle)
    implementation(Socket.okhttp)
    implementation(Socket.okhttpLogging)
    implementation(Socket.gson)
}