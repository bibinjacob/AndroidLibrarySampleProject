package emp.example.library.employee.base.data.network.entity

import emp.example.library.employee.base.domain.entity.ResponseEntity
import emp.example.library.employee.employeemanagement.data.model.EmployeeData
import emp.example.library.employee.employeemanagement.domain.entity.EmployeeDataEntity

internal fun ResponseData<EmployeeData>.mapToEmployeeDataEntity(): ResponseEntity<EmployeeDataEntity> {
    return ResponseEntity(
        data = this.data?.map {
            it.mapToEntityData()
        },
        message = this.message,
        statusCode = this.statusCode
    )
}

private fun EmployeeData.mapToEntityData(): EmployeeDataEntity {
    return EmployeeDataEntity(
        employeeID = this.employeeID ?: "",
        status = this.status ?: "",
        employeeNumber = this.employeeNumber ?: 0
    )
}

