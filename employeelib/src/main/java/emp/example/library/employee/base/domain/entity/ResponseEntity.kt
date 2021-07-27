package emp.example.library.employee.base.domain.entity

import androidx.annotation.Keep

@Keep
internal data class ResponseEntity<T>(
    val data: List<T>? = null,
    var message: String = "",
    val statusCode: Int = 0
)