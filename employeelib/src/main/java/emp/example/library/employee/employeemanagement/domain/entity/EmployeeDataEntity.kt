package emp.example.library.employee.employeemanagement.domain.entity

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
internal data class EmployeeDataEntity(
    val employeeID: String,
    val status: String,
    var employeeNumber: Int,
) : Parcelable