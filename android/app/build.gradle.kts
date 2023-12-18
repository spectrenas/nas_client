import java.util.Properties

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("dev.flutter.flutter-gradle-plugin")
}

val localProperties = Properties().also {
    val localPropertiesFile = rootProject.file("local.properties")
    if (localPropertiesFile.exists()) {
        it.load(localPropertiesFile.reader())
    }
}


var flutterVersionCode = localProperties.getProperty("flutter.versionCode").let item@{
    if (it == null) {
      return@item "1"
    }
    it
}

var flutterVersionName = localProperties.getProperty("flutter.versionName").let item@{
    if (it == null) {
        return@item "1.0"
    }
    it
}

android {

    namespace = "com.example.nas_client"
    compileSdk = FlutterExtension.getCompileSdkVersion()
    ndkVersion = FlutterExtension.getNdkVersion()

    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    sourceSets["main"].java.srcDirs.plus(sourceSets["main"].java.srcDirs("src/main/kotlin"))

    defaultConfig {
        // TODO: Specify your own unique Application ID (https://developer.android.com/studio/build/application-id.html).
        applicationId = "com.example.nas_client"
        // You can update the following values to match your application needs.
        // For more information, see: https://docs.flutter.dev/deployment/android#reviewing-the-gradle-build-configuration.
        minSdk = FlutterExtension.getMinSdkVersion()
        targetSdk = FlutterExtension.getTargetSdkVersion()
        versionCode = flutterVersionCode.toInt()
        versionName = flutterVersionName
    }

    buildTypes {
        release {
            // TODO: Add your own signing config for the release build.
            // Signing with the debug keys for now, so `flutter run --release` works.
            signingConfig = signingConfigs["debug"]
        }
    }
}

flutter {

    source = "../.."
}

dependencies {}
