package fr.hamtec.composeui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import fr.hamtec.composeui.lesListes.FirstLazyColumn
import fr.hamtec.composeui.ui.theme.AteliersJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AteliersJetpackComposeTheme() {
                Surface(modifier = Modifier.padding(start = 10.dp, top = 25.dp)) {
                    FirstLazyColumn()
                }
            }
        }
    }
}
