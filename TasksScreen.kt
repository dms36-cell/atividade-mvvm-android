import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun TasksScreen(viewModel: TasksViewModel = viewModel()) {
    // A View observa o estado (StateFlow) do ViewModel.
    val state by viewModel.uiState.collectAsState()

    // O Composable reage ao estado atual.
    when (state) {
        is TasksUiState.Loading -> Text("Carregando...")
        is TasksUiState.Error -> Text("Erro: ${(state as TasksUiState.Error).message}")
        is TasksUiState.Success -> {
            val tasks = (state as TasksUiState.Success).tasks
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Minhas Tarefas", style = MaterialTheme.typography.titleLarge)
                Spacer(Modifier.height(8.dp))
                for (task in tasks) {
                    Text("- $task")
                }
            }
        }
    }
}
