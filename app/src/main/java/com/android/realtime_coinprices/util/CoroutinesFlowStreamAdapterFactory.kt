package com.android.realtime_coinprices.util

import com.tinder.scarlet.StreamAdapter
import com.tinder.scarlet.utils.getRawType
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import java.lang.reflect.Type

@ExperimentalCoroutinesApi
class CoroutinesFlowStreamAdapterFactory : StreamAdapter.Factory {
    override fun create(type: Type): StreamAdapter<Any, Any> {
        return when (type.getRawType()) {
            Flow::class.java -> FlowStreamAdapter()
            else -> throw IllegalArgumentException()
        }
    }
}