package emp.example.library.employee.base.data.network.entity

import androidx.annotation.Keep

@Keep
internal data class ResponseData<T>(
    var data: List<T>? = null,
    val message: String = "",
    val statusCode: Int = 0
)