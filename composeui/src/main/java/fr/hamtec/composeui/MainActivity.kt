package fr.hamtec.composeui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.union
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.ui.Modifier
import fr.hamtec.composeui.miseEnPage.LayoutRow
import fr.hamtec.composeui.ui.theme.AteliersJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AteliersJetpackComposeTheme() {
                //++ Affichage du composant
                // Veillez à ce qu'il y ait au moins 120 pixels d'écart avec le haut de la page.
                // Créer un WindowInsets avec des dimensions fixes.
                val insets = WindowInsets.statusBars.union(WindowInsets(top = 120))
                Box(Modifier.windowInsetsPadding(insets)) {
                    LayoutRow()
                }
            }
        }
    }
}
