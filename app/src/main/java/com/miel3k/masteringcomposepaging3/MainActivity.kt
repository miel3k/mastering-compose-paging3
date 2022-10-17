package com.miel3k.masteringcomposepaging3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.miel3k.masteringcomposepaging3.navigation.AppNavGraph
import com.miel3k.masteringcomposepaging3.ui.theme.MasteringComposePaging3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MasteringComposePaging3Theme {
                val navController = rememberNavController()
                AppNavGraph(navController)
            }
        }
    }
}