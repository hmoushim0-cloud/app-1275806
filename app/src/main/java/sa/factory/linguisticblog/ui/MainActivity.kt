package sa.factory.linguisticblog.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import sa.factory.linguisticblog.data.InMemoryمدونةRepository

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val repository = InMemoryمدونةRepository()
        val viewModel = مدونةViewModel(repository)
        setContent {
            مدونةMainScreen(
                viewModel = viewModel,
                onNavigateDetails = {}
            )
        }
    }
}
