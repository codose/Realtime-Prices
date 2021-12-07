package com.android.realtime_coinprices.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.android.realtime_coinprices.R
import com.android.realtime_coinprices.data.TickerResponse
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box{
                val viewModel by viewModels<MainViewModel>()
                val prices = viewModel.observePriceChanges().collectAsState(initial = TickerResponse(0.0))
                Text(text = prices.value.price.toString(), modifier  = Modifier.align(Alignment.Center))
            }
        }
    }
}