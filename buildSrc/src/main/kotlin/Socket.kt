object Socket {
    private const val scarletVersion = "0.2.4"
    private const val okhttp3Version = "4.9.0"
    private const val gsonVersion = "2.8.9"

    const val scarlet = "com.github.tinder.scarlet:scarlet:$scarletVersion"

    // Optional
    const val scarletOkhttp = "com.github.tinder.scarlet:scarlet-protocol-websocket-okhttp:$scarletVersion"
    const val scarletCoroutines = "com.github.tinder.scarlet:scarlet-stream-adapter-coroutines:$scarletVersion"
    const val scarletGson = "com.github.tinder.scarlet:scarlet-message-adapter-gson:$scarletVersion"
    const val scarletLifecycle = "com.github.tinder.scarlet:scarlet-lifecycle-android:$scarletVersion"
    const val okhttp = "com.squareup.okhttp3:okhttp"
    const val okhttpLogging = "com.squareup.okhttp3:logging-interceptor"
    const val gson = "com.google.code.gson:gson:$gsonVersion"
    const val okhttpBom = "com.squareup.okhttp3:okhttp-bom:$okhttp3Version"

}