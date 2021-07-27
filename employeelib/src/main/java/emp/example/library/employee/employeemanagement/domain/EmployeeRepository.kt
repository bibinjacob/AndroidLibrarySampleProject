package emp.example.library.employee.employeemanagement.domain

import emp.example.library.employee.base.domain.entity.ResponseEntity
import emp.example.library.employee.employeemanagement.domain.entity.EmployeeDataEntity
import io.reactivex.Single

internal interface EmployeeRepository {

    fun getEmployeeData(
        employeeID: String
    ): Single<ResponseEntity<EmployeeDataEntity>>
}