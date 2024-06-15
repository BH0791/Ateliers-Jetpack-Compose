package fr.hamtec.themingcodelab.reply.data.ui

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.hamtec.themingcodelab.reply.data.LocalEmailsDataProvider
import fr.hamtec.themingcodelab.reply.data.ui.theme.ReplyTheme
import fr.hamtec.themingcodelab.reply.ui.ReplyApp
import fr.hamtec.themingcodelab.reply.ui.ReplyHomeUIState
import fr.hamtec.themingcodelab.reply.ui.ReplyHomeViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: ReplyHomeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ReplyTheme {
                val uiState by viewModel.uiState.collectAsState()
                Surface(
                    modifier = Modifier.padding(top = 20.dp),
                    tonalElevation = 5.dp
                ) {
                    ReplyApp(
                        replyHomeUIState = uiState,
                        closeDetailScreen = {
                            viewModel.closeDetailScreen()
                        },
                        navigateToDetail = { emailId ->
                            viewModel.setSelectedEmail(emailId)
                        }
                    )
                }
            }
        }
    }
}

@Preview(
    uiMode = UI_MODE_NIGHT_YES,
    name = "DefaultPreviewDark"
)
@Preview(
    uiMode = UI_MODE_NIGHT_NO,
    name = "DefaultPreviewLight"
)
@Composable
fun ReplyAppPreviewLight() {
    ReplyApp(
        replyHomeUIState = ReplyHomeUIState(
            emails = LocalEmailsDataProvider.allEmails
        )
    )
}