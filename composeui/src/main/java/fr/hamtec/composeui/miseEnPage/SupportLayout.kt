package fr.hamtec.composeui.miseEnPage

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
@Preview(showBackground = true)
@Composable
fun HorizontalScrollSample(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
            .padding(1.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp)

    ) {
        repeat(11) {
            Box(
                Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = "$it",
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun LayoutRow(): Unit {
    Row {
        // The child with no weight will have the specified size.
        Box(
            Modifier
                .size(40.dp, 80.dp)
                .background(Color.Magenta)
        )
        // Has weight, the child will occupy half of the remaining width.
        Box(
            Modifier
                .height(40.dp)
                .weight(1f)
                .background(Color.Yellow)
        )
        // Has weight and does not fill, the child will occupy at most half of the remaining width.
        // Therefore it will occupy 80.dp (its preferred width) if the assigned width is larger.
        Box(
            Modifier
                .size(80.dp, 40.dp)
                .weight(1f, fill = false)
                .background(Color.Green)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun LayoutRow2() {
    Row(Modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier
                .size(80.dp, 40.dp)
                .alignBy { it.measuredHeight / 2 }
                .background(Color.Magenta)
        )
        Text(
            text = "Text 1",
            fontSize = 40.sp,
            modifier = Modifier
                .alignByBaseline()
                .background(color = Color.Red)
        )
        Text(
            text = "Text 2",
            modifier = Modifier
                .alignByBaseline()
                .background(color = Color.Cyan)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun LayoutRow3() {
    Row {
        Box(
            Modifier
                .size(100.dp)
                .background(Color.Red))
        Spacer(Modifier.width(20.dp))
        Box(
            Modifier
                .size(100.dp)
                .background(Color.Magenta))
        Spacer(Modifier.weight(1f))
        Box(
            Modifier
                .size(100.dp)
                .background(Color.Black))
    }
}

@Preview(showBackground = true)
@Composable
fun LayoutText() {
    var offset by remember { mutableStateOf(0) }
    Text(
        "Layout offset modifier sample",
        Modifier
            .clickable { offset += 10 }
            .absoluteOffset { IntOffset(offset, offset) }
    )
}





