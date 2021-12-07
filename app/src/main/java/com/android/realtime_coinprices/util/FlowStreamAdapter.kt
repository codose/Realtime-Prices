package com.android.realtime_coinprices.util

import com.tinder.scarlet.Stream
import com.tinder.scarlet.StreamAdapter
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.reactive.asFlow

@ExperimentalCoroutinesApi
class FlowStreamAdapter<T : Any> : StreamAdapter<T, Flow<T>> {
    override fun adapt(stream: Stream<T>): Flow<T> = stream.asFlow()
}
