package emp.example.library.employee.employeemanagement.presentation

import emp.example.library.employee.employeemanagement.domain.EmployeeUseCase
import emp.example.library.employee.general.home.presentation.BaseTabViewModel
import io.reactivex.disposables.Disposable

internal class EmployeeViewModel(private val employeeUseCase: EmployeeUseCase) :
    BaseTabViewModel() {
    private var disposable: Disposable? = null

    fun getEmployeeDetails(empID: String, replaceNumber: Boolean) {
        disposable?.dispose()
        disposable =
            employeeUseCase.getEmployeeData(empID).map {

            }.subscribe()
        disposable?.let { addDisposable(it) }
    }
}