package com.sommerengineering.robinhoodinterview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sommerengineering.robinhoodinterview.ui.theme.RobinhoodInterviewTheme

class MainActivity : ComponentActivity() {

    val viewModel: RobinhoodViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val instruments = viewModel.instruments.value

        setContent {
            RobinhoodInterviewTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()) { innerPadding ->

                    TextField(
                        value = "",
                        onValueChange = { chars ->
                            instruments.filter { instrument ->
                                instrument.instrument_type.contains(chars)
                            }
                        })

                    Column {

                        instruments.forEach { instrument ->
                            Text(
                                text = "name: ${instrument.name}")
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