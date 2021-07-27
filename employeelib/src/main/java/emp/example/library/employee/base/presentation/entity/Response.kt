package emp.example.library.employee.base.presentation.entity

import androidx.annotation.Keep

@Keep
internal data class Response(
    val statusCode: Int = 0,
    val message: String = ""
)