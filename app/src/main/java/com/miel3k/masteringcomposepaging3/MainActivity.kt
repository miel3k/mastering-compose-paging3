package com.miel3k.masteringcomposepaging3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.miel3k.masteringcomposepaging3.navigation.AppNavGraph
import com.miel3k.masteringcomposepaging3.ui.theme.Masteringcomposepaging3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Masteringcomposepaging3Theme {
                val navController = rememberNavController()
                AppNavGraph(navController)
            }
        }
    }
}