package emp.example.library.employee.employeemanagement.data.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
internal data class EmployeeData(
    val employeeID: String? = "",
    val status: String? = "",
    val employeeNumber: Int? = 0
)