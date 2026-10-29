package sa.factory.linguisticblog.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import sa.factory.linguisticblog.data.مدونةRepository
import sa.factory.linguisticblog.model.مدونة
import sa.factory.linguisticblog.model.مقال
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class مدونةViewModel(
    private val repository: مدونةRepository
) : ViewModel() {
    val catalog: StateFlow<List<مقال>> = repository.getAvailableCatalog()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val activeRequest: StateFlow<مدونة?> = repository.getActiveRequest()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), null)

    fun submitNewOrder(request: مدونة) {
        viewModelScope.launch {
            repository.submitRequest(request)
        }
    }
}
