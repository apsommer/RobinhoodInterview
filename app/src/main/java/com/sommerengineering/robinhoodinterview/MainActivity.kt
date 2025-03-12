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
import androidx.compose.foundation.layout.fillMaxWidth
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

    private val viewModel: RobinhoodViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RobinhoodInterviewTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()) { innerPadding ->

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .padding(48.dp)) {

                        // user text input
                        var text by remember { mutableStateOf("") }
                        var filteredInstruments by remember { viewModel.instruments }

                        TextField(
                            value = text,
                            onValueChange = { filterByChars ->
                                text = filterByChars
                                filteredInstruments = viewModel.instruments.value.filter {
                                    it.instrument_type.contains(filterByChars)
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth())

                        Spacer(
                            modifier = Modifier.size(16.dp))

                        filteredInstruments.forEach { instrument ->
                            Text(instrument.name)
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