package emp.example.library.employee.employeemanagement.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.navGraphViewModels
import emp.example.library.employee.R
import emp.example.library.employee.base.presentation.BaseFragment
import emp.example.library.employee.base.presentation.BaseViewModel
import emp.example.library.employee.databinding.FragmentTabTwoBinding
import emp.example.library.employee.di.EmployeeLibProvider

class TabTwoFragment : BaseFragment() {

    private val employeeViewModel: EmployeeViewModel by navGraphViewModels(R.id.employee_lib_navigation) {
        viewModelFactory
    }

    companion object {
        fun newInstance() = TabTwoFragment()
    }

    override fun getViewModel(): BaseViewModel {
        return employeeViewModel
    }

    private lateinit var binding: FragmentTabTwoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTabTwoBinding.inflate(inflater, container, false)
        viewModelFactory = EmployeeLibProvider.provideTabsViewModelFactory()
        binding.lifecycleOwner = this
        return binding.root
    }
}