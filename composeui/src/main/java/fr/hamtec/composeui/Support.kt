package fr.hamtec.composeui

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.ConnectedTv
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.rounded.People
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.hamtec.composeui.ui.theme.AteliersJetpackComposeTheme
import java.time.Instant

@Composable
fun CoversationItem(
    name: String,
    message: String,
    date: Instant,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
            .clickable (onClickLabel = stringResource(R.string.cd_open_conversation)){
                /*TODO*/
            }
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
            MessageContent(message, date.toString().substring(11, 16))
//        Conversation()
//        LastMessage(
//            name = name,
//            message = message,
//            date = date,
//            modifier = Modifier.weight(1f)
//        )
    }

}

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

@Composable
fun UserBadge(username: String) {
    Row {
        Icon(
            imageVector = Icons.Rounded.People,
            contentDescription = "User Badge",
            modifier = Modifier
                .size(20.dp)
                .border(
                    width = 0.5.dp,
                    color = MaterialTheme.colorScheme.error,
                    shape = CircleShape
                )
                .padding(2.dp)
        )
        Text(
            text = username,
            modifier = Modifier
                .padding(start = 4.dp)
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

@Composable
fun MessageContent(
    text: String,
    time: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .border(
                width = 2.dp,
                color = MaterialTheme.colorScheme.secondary,
                shape = MaterialTheme.shapes.small
            )
            .padding(8.dp)
    ) {
        Text(
            text = text,
            color = MaterialTheme.colorScheme.primary,
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            text = time,
            modifier = Modifier.align(Alignment.End),
            color = MaterialTheme.colorScheme.tertiary,
            style = MaterialTheme.typography.titleSmall
        )
    }
}

/**
 * Plusieurs styles au sein d'un même texte
 *
 * Affiche différentes parties du texte dans des styles différents.
 * @author HB
 */
fun String.highlightMentions(color: Color): AnnotatedString {
    val words: List<String> = this.split(" ")

    return buildAnnotatedString {
        words.forEachIndexed { index, word ->
            if (word.startsWith("@")) {
                withStyle(style = SpanStyle(color = color)) {
                    append(word)
                }
            } else {
                append(word)
            }
            if (index < words.count() - 1) {
                append(" ")
            }
        }
    }
}

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

//++ +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ Preview
@Preview(showBackground = true, group = "Book-TP")
@Composable
fun PreviewUserBadge() {
    UserBadge(username = "hamid")
}

@Preview(showBackground = true, group = "Book-Divers")
@Composable
private fun SingleTextPreview() {
    AteliersJetpackComposeTheme {
        SingleText()
    }
}

@Preview(showBackground = true, group = "Book-TP")
@Composable
private fun MessageContentPreview() {
    AteliersJetpackComposeTheme {
        MessageContent("You like potato and I like potahto", "6:31 pm")
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
private fun SimpleButtonPreview() {
    AteliersJetpackComposeTheme {
        SimpleButton()
    }
}

@Preview(showBackground = true, group = "Book-Divers")
@Composable
private fun SimpleIconButtonPreview() {
    AteliersJetpackComposeTheme { SimpleIconButton() }
}

@Preview(showBackground = true)
@Composable
fun CoversationItemPreview() {
    AteliersJetpackComposeTheme {
        CoversationItem("Louise", "Bonjour à tous", Instant.now())
    }
}