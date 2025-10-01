import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class TasksViewModel : ViewModel() {
    // 1. O estado MUTÁVEL (privado)
    private val _uiState = MutableStateFlow<TasksUiState>(TasksUiState.Loading)
    
    // 2. O estado IMUTÁVEL (público) que a View observa
    val uiState: StateFlow<TasksUiState> = _uiState.asStateFlow()

    init {
        loadTasks()
    }

    private fun loadTasks() {
        // Simulação de carregamento de dados (passando para estado Success)
        val tasks = listOf("Estudar MVVM", "Fazer atividade", "Enviar no GitHub")
        _uiState.value = TasksUiState.Success(tasks)
    }
}
