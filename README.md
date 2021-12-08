# Realtime Coin Prices

## Features 🎨

- **100% Kotlin-only project**.
- REST Api Integration,Hilt,GSon,AndroidX,MVVM,Okhttp,Scarlet Websocket, Jetpack Compose
- 100% Gradle Kotlin DSL setup.
- Dependency versions managed via `buildSrc`.
- Issues project (bug report + feature request)
- Coinbase Websocket API



## Gradle Setup 🐘

This project is using [**Gradle Kotlin DSL**](https://docs.gradle.org/current/userguide/kotlin_dsl.html) as well as the [Plugin DSL](https://docs.gradle.org/current/userguide/plugins.html#sec:plugins_block) to setup the build.

Dependencies are centralized inside the [buildSrc](buildSrc/src/main/java) folder. This provides convenient auto-completion when writing your gradle files.

## How To Build
Pull the code on this branch, import into Android Studio, from there you can run it like a standard
android project project or run ./gradlew assembleDebug. Further notes can be found here https://developer.android.com/studio/build/building-cmdline#DebugMode
