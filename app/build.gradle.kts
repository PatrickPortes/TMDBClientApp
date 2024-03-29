import java.util.Properties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("kotlin-kapt")
}

android {
    namespace = "com.example.tmdbclientapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.tmdbclientapp"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        val properties = Properties()
        properties.load(project.rootProject.file("local.properties").inputStream())
        buildConfigField("String", "API_KEY", "\"${properties.getProperty("API_KEY")}\"")

        buildConfigField("String","BASE_URL","\"https://api.themoviedb.org/3/\"")
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        dataBinding = true
        viewBinding = true
        buildConfig = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
//    testImplementation("junit:junit:4.10.0")
//    androidTestImplementation("androidx.test.ext:junit:1.1.5")
//    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //ViewModel - Kotlin
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")

    //LiveData   - Kotlin
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")

    //Lifecycle Annotation Processor
    kapt("androidx.lifecycle:lifecycle-compiler:2.7.0")

    //Navigation - Kotlin
    implementation ("androidx.navigation:navigation-fragment-ktx:2.7.6")
    implementation ("androidx.navigation:navigation-ui-ktx:2.7.6")

    //Coroutines - Kotlin
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.0-RC2")

    //Room Data Storage
    implementation("androidx.room:room-runtime:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")
    kapt("androidx.room:room-compiler:2.6.1")

    //Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.5.0")

    //Dagger2
    implementation("com.google.dagger:dagger:2.50")
    kapt("com.google.dagger:dagger-compiler:2.50")

    //Glide
    implementation("com.github.bumptech.glide:glide:4.16.0")

    //Test:
    testImplementation("junit:junit:4.13.2")
    testImplementation("androidx.arch.core:core-testing:2.2.0")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.2.1")
    testImplementation("com.google.truth:truth:1.0.1")
    testImplementation("androidx.test.ext:junit:1.1.5")
    testImplementation("org.robolectric:robolectric:4.4")

    androidTestImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.arch.core:core-testing:2.2.0")
    androidTestImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.2.1")
    androidTestImplementation("com.google.truth:truth:1.0.1")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

}