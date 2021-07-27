package emp.example.library.employee.employeemanagement.data

import emp.example.library.employee.base.data.network.RepoService
import emp.example.library.employee.base.data.network.entity.mapToEmployeeDataEntity
import emp.example.library.employee.base.domain.entity.ResponseEntity
import emp.example.library.employee.employeemanagement.domain.EmployeeRepository
import emp.example.library.employee.employeemanagement.domain.entity.EmployeeDataEntity
import io.reactivex.Single

/**
 * Implementation class of Domain Repository
 * */
internal class EmployeeRepositoryImpl(private val repoService: RepoService) :
    EmployeeRepository {
    override fun getEmployeeData(
        employeeID: String
    ): Single<ResponseEntity<EmployeeDataEntity>> {

        return repoService.getEmployeeData(
            employeeID = employeeID
        ).map {
            it.mapToEmployeeDataEntity()
        }
    }
}

