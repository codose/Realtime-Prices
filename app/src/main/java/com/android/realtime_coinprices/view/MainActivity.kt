package com.android.realtime_coinprices.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.android.realtime_coinprices.R
import com.android.realtime_coinprices.data.repository.TickerResponse
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(Modifier.padding(horizontal = 16.dp, vertical = 16.dp)) {
                val viewModel by viewModels<MainViewModel>()
                val prices = viewModel.getTickersFromDb().collectAsState(initial = null)
                LazyColumn {
                    prices.value?.let {
                        items(it.size) { count ->
                            val ticker = it[count]
                            Spacer(modifier = (Modifier.height(12.dp)))
                            Text(text = ticker.productId.replace("-", "/"), modifier = Modifier.align(Alignment.Center))
                            Spacer(modifier = (Modifier.height(4.dp)))
                            Text(text = ticker.price.toString(), modifier = Modifier.align(Alignment.Center))
                            Spacer(modifier = (Modifier.height(12.dp)))
                            Divider(modifier = Modifier.fillMaxWidth())

                        }
                    }
                }
            }
        }
    }
}