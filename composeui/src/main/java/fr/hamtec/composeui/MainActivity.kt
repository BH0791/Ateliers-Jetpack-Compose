package fr.hamtec.composeui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import fr.hamtec.composeui.tpviewmodel.MyScreen
import fr.hamtec.composeui.ui.theme.AteliersJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AteliersJetpackComposeTheme() {
                //++ Affichage du composant
                    MyScreen()
            }
        }
    }
}
