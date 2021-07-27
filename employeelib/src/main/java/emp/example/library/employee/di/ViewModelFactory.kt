package emp.example.library.employee.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import emp.example.library.employee.employeemanagement.domain.EmployeeUseCase

internal class TabsViewModelFactory(
    private val employeeUseCase: EmployeeUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(EmployeeUseCase::class.java)
            .newInstance(employeeUseCase)
    }
}

internal class EmployeeViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor().newInstance()
    }
}
