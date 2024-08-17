package fr.hamtec.composeui

import android.annotation.SuppressLint
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.ConnectedTv
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.text
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldWithIcons() {
    var text by rememberSaveable { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Label") },
        leadingIcon = { Icon(Icons.Filled.Favorite, contentDescription = "Localized description") },
        trailingIcon = { Icon(Icons.Filled.Info, contentDescription = "Localized description") }
    )
}

@Composable
fun TextFieldWithPrefixAndSuffix() {
    var text by rememberSaveable { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        singleLine = true,
        label = { Text("Label") },
        prefix = { Text("www.") },
        suffix = { Text(".com") },
        placeholder = { Text("google") },
    )
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
fun TextFieldWithErrorState() {
    val errorMessage = "Text input too long"
    var text by rememberSaveable { mutableStateOf("") }
    var isError by rememberSaveable { mutableStateOf(false) }
    val charLimit = 10

    fun validate(text: String) {
        isError = text.length > charLimit
    }

    TextField(
        value = text,
        onValueChange = {
            text = it
            validate(text)
        },
        singleLine = true,
        label = { Text(if (isError) "Username*" else "Username") },
        supportingText = {
            Row {
                Text(if (isError) errorMessage else "", Modifier.clearAndSetSemantics {})
                Spacer(Modifier.weight(1f))
                Text("Limit: ${text.length}/$charLimit")
            }
        },
        isError = isError,
        keyboardActions = KeyboardActions { validate(text) },
        modifier =
        Modifier.semantics {
            // Provide localized description of the error
            if (isError) error(errorMessage)
        }
    )
}

@Composable
fun SimpleOutlinedTextFieldSample() {
    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Label") }
    )
}
@Composable
fun StyledTextField() {
    var value by remember { mutableStateOf("Hello\nWorld\nInvisible") }

    TextField(
        value = value,
        onValueChange = { value = it },
        label = { Text("Enter text") },
        maxLines = 2,
        textStyle = TextStyle(color = Color.Blue, fontWeight = FontWeight.Bold),
        modifier = Modifier.padding(20.dp)
    )
}
fun rainbowColors(): List<Color> {
    return listOf(Color.Black, Color.Cyan, Color.Blue, Color.Green, Color.Red /*...*/)
}
@Composable
fun AvecColor() {
    var text by remember { mutableStateOf("") }
    val brush = remember {
        Brush.linearGradient(
            colors = rainbowColors()
        )
    }
    TextField(
        value = text, onValueChange = { text = it }, textStyle = TextStyle(brush = brush)
    )
}
@Preview(showBackground = true, group = "Book-Ch_formulaire")
@Composable
fun AvecColorPreview(){
    AteliersJetpackComposeTheme {
        AvecColor()
    }
}
@Preview(showBackground = true, group = "Book-Ch_formulaire")
@Composable
private fun SimpleOutlinedTextFieldSamp() {
    AteliersJetpackComposeTheme {
        SimpleOutlinedTextFieldSample()
    }
}
@Preview(showBackground = true, group = "Book-Ch_formulaire")
@Composable
fun SimpleOutlinedTextFieldSampPreview() {
    AteliersJetpackComposeTheme {
        TextFieldWithErrorState()
    }
}
@Preview(showBackground = true, group = "Book-Ch_formulaire")
@Composable
fun TextFieldWithErrorStatePreview() {
    AteliersJetpackComposeTheme {
        TextFieldWithErrorState()
    }
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

@Preview(showBackground = true, group = "Book-Ch_formulaire")
@Composable
fun TextFieldWithPrefixAndSuffixPreview() {
    AteliersJetpackComposeTheme {
        TextFieldWithPrefixAndSuffix()
    }
}

@Preview(showBackground = true, group = "Book-Ch_formulaire")
@Composable
private fun TextFieldWithIconsPreview() {
    AteliersJetpackComposeTheme {
        TextFieldWithIcons()
    }
}