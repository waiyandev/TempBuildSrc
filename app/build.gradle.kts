import org.gradle.internal.impldep.com.jcraft.jsch.ConfigRepository.defaultConfig

//plugins {
//    id 'com.android.application'
//    id 'org.jetbrains.kotlin.android'
//}
plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.jetBrainKotlin)
}

android {
    compileSdkVersion(AndroidSdk.compile)
//    compileSdk = AndroidSdk.compile

    defaultConfig {
        applicationId = "com.showti.temp"
//        minSdk = AndroidSdk.min
//        targetSdk = AndroidSdk.target
        minSdkVersion(AndroidSdk.min)
        targetSdkVersion(AndroidSdk.target)
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildFeatures {
        dataBinding = true
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }

}

dependencies {

//    implementation(Libraries.kotlinStdLib)
    implementation(Libraries.appCompat)
    implementation(Libraries.ktxCore)
    implementation(Libraries.constraintLayout)
    implementation(Libraries.material)

    testImplementation (TestLibraries.junit4)
    androidTestImplementation (TestLibraries.testRunner)
    androidTestImplementation (TestLibraries.espresso)
}