package sa.factory.linguisticblog.data

import sa.factory.linguisticblog.model.مدونة
import sa.factory.linguisticblog.model.مقال
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

interface مدونةRepository {
    fun getAvailableCatalog(): Flow<List<مقال>>
    fun getActiveRequest(): Flow<مدونة?>
    suspend fun submitRequest(request: مدونة): Result<String>
}

class InMemoryمدونةRepository : مدونةRepository {
    private val _catalog = MutableStateFlow<List<مقال>>(listOf(
        مقال("1", "إضافة مدخل نصي", "إضافة نصوص ومقالات لغوية إلى المدونة", 5000L, "assignment"),
        مقال("2", "إضافة مدخل صوتي", "تحميل ملفات صوتية ذات صلة بالمحتوى اللغوي", 9500L, "support")
    ))
    private val _active = MutableStateFlow<مدونة?>(null)

    override fun getAvailableCatalog(): Flow<List<مقال>> = _catalog.asStateFlow()
    override fun getActiveRequest(): Flow<مدونة?> = _active.asStateFlow()

    override suspend fun submitRequest(request: مدونة): Result<String> {
        _active.value = request
        return Result.success(request.requestId)
    }
}
