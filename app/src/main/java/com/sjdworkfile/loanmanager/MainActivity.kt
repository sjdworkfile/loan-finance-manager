package com.sjdworkfile.loanmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dagger.hilt.android.AndroidEntryPoint
import com.sjdworkfile.loanmanager.presentation.navigation.AppNavigation
import com.sjdworkfile.loanmanager.presentation.theme.LoanManagerTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoanManagerTheme {
                AppNavigation()
            }
        }
    }
}
