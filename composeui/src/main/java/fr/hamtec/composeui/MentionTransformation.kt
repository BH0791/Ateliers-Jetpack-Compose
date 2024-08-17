package fr.hamtec.composeui

import android.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle

class MentionTransformation(private val color: Color) : VisualTransformation {

    fun buildAnnotatedStringWithMention(texte: String, color: Color): AnnotatedString {
        val words: List<String> = texte.split(" ")

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
//    override fun filter(text: AnnotatedString): TransformedText {
//
//        return TransformedText(
//            buildAnnotatedStringWithMention(
//                text = text.toString(),
//                color = color
//            ),
//            offsetMapping = OffsetMapping.Identity
//        )
//
//    }
}