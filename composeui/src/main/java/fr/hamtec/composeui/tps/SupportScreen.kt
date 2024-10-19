package fr.hamtec.composeui.tps

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AfficheTP() {
    Scaffold {

        Surface(modifier = Modifier.padding(it)) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                UserBadge(username = "Louis Amstrong")
            }
        }

    }
}
