package emp.example.library.employee.general.home.presentation

import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import emp.example.library.employee.base.presentation.BaseViewModel
import emp.example.library.employee.employeemanagement.presentation.TabOneFragment
import emp.example.library.employee.employeemanagement.presentation.TabTwoFragment


internal class TabsViewModel : BaseViewModel() {
    private val employeeFragments = listOf<Fragment>(
        TabOneFragment.newInstance(),
        TabTwoFragment.newInstance()
    )

    fun getFragmentListForViewpager(): List<Fragment> {
        return employeeFragments
    }
}