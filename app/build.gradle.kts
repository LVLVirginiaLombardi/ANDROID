plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.example.myappwithmvvm"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.myappwithmvvm"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.2"
    }
    packagingOptions {
        resources.excludes.apply {
            add("META-INF/AL2.0")
            add("META-INF/LGPL2.1")
            add("META-INF/licenses/**")
            add("**/attach_hotspot_windows.dll")
            add ("META-INF/LICENSE")
            add ("META-INF/*.properties")
            add ("META-INF/gradle/**")
            add("META-INF/services/javax.annotation.processing.Processor")
            add ("META-INF/DEPENDENCIES.txt")
            add ("META-INF/LICENSE.txt")
            add ("META-INF/NOTICE.txt")
            add ("META-INF/NOTICE")
            add ("META-INF/DEPENDENCIES")
            add ("META-INF/notice.txt")
            add ("META-INF/license.txt")
            add ("META-INF/dependencies.txt")
        }
    }
}

dependencies {
    val DAGGER_VERSION = "2.44.2"
    val DAGGER = "com.google.dagger:dagger:${DAGGER_VERSION}"
    val DAGGER_COMPILER = "com.google.dagger:dagger-compiler:${DAGGER_VERSION}"
    val DAGGER_ANNOTATION_PROCESSOR =
        "com.google.dagger:dagger-android-processor:${DAGGER_VERSION}"
    val daggerAndroidSupport =
        "com.google.dagger:dagger-android-support:${DAGGER_VERSION}"
    implementation(DAGGER)
    implementation(DAGGER_COMPILER)
    implementation(DAGGER_ANNOTATION_PROCESSOR)
    implementation(daggerAndroidSupport)
    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation ("androidx.datastore:datastore-preferences:1.0.0")
    implementation("androidx.activity:activity-compose:1.7.2")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}