// ============================================================
// build.gradle.kts — Module :listbuah
// Aplikasi ListView Buah-buahan
// ============================================================
plugins {
    id("com.android.application")
}

android {
    namespace = "com.mobile.listbuah"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.mobile.listbuah"
        minSdk = 24
        targetSdk = 36
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    // AppCompat - Untuk ActionBar / Toolbar
    implementation("androidx.appcompat:appcompat:1.6.1")

    // Material Design Components
    implementation("com.google.android.material:material:1.11.0")

    // ConstraintLayout
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    // Core KTX (untuk utilitas Android)
    implementation("androidx.core:core-ktx:1.12.0")

    // RecyclerView (opsional, kalau mau upgrade dari ListView)
    implementation("androidx.recyclerview:recyclerview:1.3.2")

    // CardView
    implementation("androidx.cardview:cardview:1.0.0")

    // Testing
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}
