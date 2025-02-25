plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = "com.tomecamueji.learntoingles"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.tomecamueji.learntoingles"
        minSdk = 24
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    //dependencias para abas
    implementation ("com.ogaclejapan.smarttablayout:library:2.0.0@aar")
    //Optional: see how to use the utility.
    implementation ("com.ogaclejapan.smarttablayout:utils-v4:2.0.0@aar")

    implementation ("com.github.lisawray.groupie:groupie:2.9.0")
    implementation ("com.github.lisawray.groupie:groupie-viewbinding:2.9.0")
    implementation ("com.github.bumptech.glide:glide:4.12.0")

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}