package emp.example.library.employee.base.presentation

import androidx.annotation.Keep
import emp.example.library.employee.base.presentation.entity.EmployeeLibParams

@Keep
object EmployeeSession {

    private lateinit var employeeLibParams: EmployeeLibParams

    fun setEmployeeLibParams(employeeLibParams: EmployeeLibParams?) {
        employeeLibParams?.let {
            EmployeeSession.employeeLibParams = it
        }
    }

    fun getBaseUrl() = if (employeeLibParams.baseUrl
            .isNotBlank()
    ) employeeLibParams.baseUrl else "http://localhost/"
}