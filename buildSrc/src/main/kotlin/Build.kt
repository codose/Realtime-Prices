object Build {
    private const val gradleBuildTools = "7.0.3"
    private const val googleServicesVersion = "4.3.10"
    private const val navigationVersion = "2.3.5"

    const val buildTools = "com.android.tools.build:gradle:$gradleBuildTools"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Kotlin.version}"
    const val hiltGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:${Hilt.version}"
    const val googleServicesPlugin = "com.google.gms:google-services:$googleServicesVersion"
    const val navigationPlugin = "androidx.navigation:navigation-safe-args-gradle-plugin:$navigationVersion"
}
