package fr.hamtec.compose.superheroes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.hamtec.compose.superheroes.model.Hero
import fr.hamtec.compose.superheroes.model.HeroesRepository
import fr.hamtec.compose.superheroes.ui.theme.AteliersJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AteliersJetpackComposeTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    SuperHeroApp()
                }
            }
        }
    }
}

@Composable
fun SuperHeroApp(
    modifier: Modifier = Modifier,
) {
    Scaffold() {it ->
        LazyColumn(contentPadding = it) {
            items(HeroesRepository.heroes) {
                SuperHeroItem(
                    superhero = it,
                    modifier = Modifier.padding(
                        horizontal = 16.dp,
                        vertical = 8.dp
                    )
                )
            }
        }
    }
}

@Composable
fun SuperHeroItem(
    superhero: Hero,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        ) {
            SuperheroIcon(superhero.imageRes)
        }
    }
}

@Composable
fun SuperheroIcon(
    @DrawableRes superHeroIcon: Int,
    modifier: Modifier = Modifier,
) {
    Image(
        contentScale = ContentScale.Crop,
        painter = painterResource(superHeroIcon),
        contentDescription = null,
        modifier = modifier
            .size(100.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun SuperHeroPreview() {
    AteliersJetpackComposeTheme {
        SuperHeroApp()
    }
}

