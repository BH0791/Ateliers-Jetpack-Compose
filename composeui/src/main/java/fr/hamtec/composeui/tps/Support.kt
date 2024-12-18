package fr.hamtec.composeui.tps

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Attachment
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.People
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.hamtec.composeui.R
import fr.hamtec.composeui.ui.theme.AteliersJetpackComposeTheme
import java.time.Instant

@Composable
fun CoversationItem(
    name: String,
    message: String,
    date: Instant,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier =
            modifier
                .clickable(onClickLabel = stringResource(R.string.cd_open_conversation)) {
                    // TODO
                }.fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 4.dp),
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

// ** P-139
@Composable
fun UserBadge(username: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(2.dp),
    ) {
        Icon(
            imageVector = Icons.Rounded.People,
            contentDescription = "User Badge",
            modifier =
                Modifier
                    .size(20.dp)
                    .border(
                        width = 0.5.dp,
                        color = MaterialTheme.colorScheme.error,
                        shape = CircleShape,
                    ).padding(2.dp),
        )
        Text(
            text = username,
            modifier =
                Modifier
                    .padding(start = 4.dp),
        )
    }
}

@Composable
fun MessageContent(
    text: String,
    time: String,
    modifier: Modifier = Modifier,
) {
    Row {
        Column(
            modifier =
                Modifier
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.secondary,
                        shape = MaterialTheme.shapes.small,
                    ).padding(4.dp),
        ) {
            Text(
                text = text,
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.bodyLarge,
            )
            Text(
                text = time,
                modifier = Modifier.align(Alignment.End),
                color = MaterialTheme.colorScheme.tertiary,
                style = MaterialTheme.typography.labelSmall,
            )
        }
        Surface(
            modifier =
                Modifier
                    .padding(start = 4.dp)
                    .align(Alignment.Bottom),
        ) {
            MessageReadIcons()
        }
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
fun NewMessageInput(
    onSendMessage: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    var text by remember { mutableStateOf("") }
    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        placeholder = {
            Text(stringResource(R.string.cd_type_a_message))
        },
        shape = MaterialTheme.shapes.small,
        value = text,
        onValueChange = {
            text = it
        },
        trailingIcon = {
            Row {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        Icons.Default.Attachment,
                        contentDescription =
                            stringResource(R.string.cd_attach),
                    )
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        Icons.Default.Mic,
                        contentDescription =
                            stringResource(R.string.cd_record),
                    )
                }
            }
        },
        keyboardOptions =
            KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Send,
            ),
        keyboardActions =
            KeyboardActions(
                onSend = {
                    onSendMessage(text)
                    text = ""
                },
            ),
    )
}

@Composable
fun ConversationItem(
    name: String,
    messsage: String,
    date: Instant,
    modifier: Modifier = Modifier,
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier =
            modifier
                .clickable(
                    onClickLabel = stringResource(R.string.cd_open_conversation),
                ) {
                    // TODO open conversation
                }.fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 4.dp),
    ) {
//        ConversationIcon()
//        LastMessage(
//            name = name,
//            message = messsage,
//            date = date,
//            modifier = Modifier.weight(1f)
//        )
    }
}

@Composable
fun MessageReadIcons(modifier: Modifier = Modifier) {
    Icon(
        imageVector = Icons.Rounded.Check,
        contentDescription = stringResource(id = R.string.cd_message_read),
        tint = Color(0xFF00C8FF),
        modifier =
            modifier
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.primary,
                    shape = CircleShape,
                ).padding(2.dp)
                .size(10.dp),
    )
}

// ++ +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ Preview
@Preview(showBackground = true, group = "Book-TP")
@Composable
fun PreviewUserBadge() {
    UserBadge(username = "hamid")
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
fun CoversationItemPreview() {
    AteliersJetpackComposeTheme {
        CoversationItem("Louise", "Bonjour à tous", Instant.now())
    }
}

@Preview(showBackground = true)
@Composable
fun NewMessageInputPreview() {
    AteliersJetpackComposeTheme {
        NewMessageInput({})
    }
}
