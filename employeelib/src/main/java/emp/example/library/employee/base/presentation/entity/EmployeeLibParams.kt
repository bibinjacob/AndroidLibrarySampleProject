package emp.example.library.employee.base.presentation.entity

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class EmployeeLibParams(
    var baseUrl: String,
    val userID: String? = ""
) : Parcelable