package fr.hamtec.composeui

import android.annotation.SuppressLint
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.ConnectedTv
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.text
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.hamtec.composeui.ui.theme.AteliersJetpackComposeTheme


@Composable
fun SimpleIconButton(modifier: Modifier = Modifier) {
    IconButton(
        {/*TODO*/ }
    ) {
        Icon(
            imageVector = Icons.Default.Send,
            contentDescription = null,
            modifier = modifier
                .size(40.dp)
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.primary,
                    shape = CircleShape
                )
                .padding(5.dp)
        )
    }
}

@SuppressLint("DefaultLocale")
@Composable
fun Rating(
    rate: Double,
    reviewCount: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            val formateRate = String.format("%.1f", rate)
            val cdAverageRateIs = AnnotatedString(
                stringResource(
                    id = R.string.cd_average_rating_is, formateRate
                )
            )
            Text(
                text = formateRate,
                modifier = Modifier.semantics {
                    text = cdAverageRateIs
                },
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary
            )
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary
            )
        }
        Text(
            text = stringResource(id = R.string.review_count, reviewCount),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Composable
fun SimpleButton(modifier: Modifier = Modifier) {
    Button(
        modifier = modifier.height(80.dp),
        onClick = {/*TODO*/ },
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 5.dp,
            pressedElevation = 10.dp,
            focusedElevation = 10.dp
        ),
        colors = ButtonDefaults.buttonColors(
            contentColor = Color(0xFF00FF00),
        ),
        contentPadding = PaddingValues(4.dp),
        shape = MaterialTheme.shapes.extraSmall

    ) {

        Column {
            Icon(
                Icons.Default.ConnectedTv,
                contentDescription = null
            )
            Text(
                text = "Lecture en cours - 90 %",
                textAlign = TextAlign.Center
            )
            Text(
                text = "TV salon",
                style = MaterialTheme.typography.titleSmall,
            )
        }
        Icon(
            Icons.Default.ChevronRight,
            modifier = Modifier.padding(start = 16.dp),
            contentDescription = null
        )

    }
}

@Composable
fun SingleText(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(id = R.string.yellow_submarine).highlightMentions(
            color = Color(0xFF00ABFF),
        ),
        modifier = modifier,
        style = MaterialTheme.typography.titleLarge.copy(
            color = Color(0xFFFAABFF),
        )
    )
}
@Preview(showBackground = true, group = "Book-Divers")
@Composable
private fun SimpleButtonPreview() {
    AteliersJetpackComposeTheme {
        SimpleButton()
    }
}

@Preview(showBackground = true)
@Composable
fun RatingPreview() {
    AteliersJetpackComposeTheme {
        Rating(4.5, 84)
    }
}


@Preview(showBackground = true, group = "Book-Divers")
@Composable
private fun SimpleIconButtonPreview() {
    AteliersJetpackComposeTheme { SimpleIconButton() }
}

@Preview(showBackground = true, group = "Book-Divers")
@Composable
private fun SingleTextPreview() {
    AteliersJetpackComposeTheme {
        SingleText()
    }
}