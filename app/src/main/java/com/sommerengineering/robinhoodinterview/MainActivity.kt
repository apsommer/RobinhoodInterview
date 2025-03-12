package com.sommerengineering.robinhoodinterview

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sommerengineering.robinhoodinterview.ui.theme.RobinhoodInterviewTheme

class MainActivity : ComponentActivity() {

    val viewModel: RobinhoodViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // launch network request
        viewModel.getInstruments()

        setContent {
            RobinhoodInterviewTheme {

                val instruments by viewModel.instruments

                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()) { innerPadding ->

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(48.dp)) {

                        // user text input
                        var text by remember { mutableStateOf("Filter ...") }
                        var filteredInstruments: List<Instrument> by remember { mutableStateOf(listOf()) }

                        TextField(
                            value = text,
                            onValueChange = { filterByChars ->
                                text = filterByChars
                                filteredInstruments = instruments.filter { instrument ->
                                    instrument.instrument_type.contains(filterByChars)
                                }
                            })

                        Spacer(
                            modifier = Modifier.size(16.dp))

                        filteredInstruments.forEach { instrument ->
                            Text("name: ${instrument.name}")
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RobinhoodInterviewTheme {
    }
}