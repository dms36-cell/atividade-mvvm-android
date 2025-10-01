sealed class TasksUiState {
    object Loading : TasksUiState()
    data class Success(val tasks: List<String>) : TasksUiState()
    data class Error(val message: String) : TasksUiState()
}
