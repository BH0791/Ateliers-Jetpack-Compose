package fr.hamtec.composeui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import fr.hamtec.composeui.livre.DifBouton
import fr.hamtec.composeui.ui.theme.AteliersJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold { innerPadding ->
                Column(modifier = Modifier.padding(innerPadding)) {
                    Row(modifier =  Modifier.padding(top = 50.dp)) {
                        AteliersJetpackComposeTheme {
                            DifBouton()
                        }
                    }
                }
            }

        }
    }
}
