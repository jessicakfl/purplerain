package com.idigue.purplerain

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.idigue.purplerain.ui.theme.PurplerainTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PurplerainTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Start,
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Button(
                            onClick = { postuser() },
                            modifier = Modifier.padding(top = 10.dp)
                        ) {
                            Text("postuser")
                        }
                    }
                }
            }
        }
    }

    private fun postuser() {
        val userapi = user(
            0, "userapi"
        )
        val httpservice = httpservice()
        println(httpservice.okpostuser(userapi))
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PurplerainTheme {
        //Greeting("Android")
    }
}