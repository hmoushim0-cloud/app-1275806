package sa.factory.linguisticblog.model

import kotlinx.serialization.Serializable

@Serializable
data class مقال(
    val id: String,
    val title: String,
    val description: String,
    val priceMinorUnits: Long,
    val iconVector: String = "verified"
)

@Serializable
data class مدونة(
    val requestId: String,
    val items: List<مقال>,
    val customerPhone: String,
    val totalAmountMinorUnits: Long,
    val status: مدونةStatus = مدونةStatus.PENDING,
    val createdAtEpochMs: Long = System.currentTimeMillis()
)

enum class مدونةStatus {
    PENDING,
    ACCEPTED,
    IN_PROGRESS,
    COMPLETED,
    CANCELLED
}
