package emp.example.library.employee.employeemanagement.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.navGraphViewModels
import emp.example.library.employee.R
import emp.example.library.employee.base.presentation.BaseFragment
import emp.example.library.employee.base.presentation.BaseViewModel
import emp.example.library.employee.databinding.FragmentTabOneBinding
import emp.example.library.employee.di.EmployeeLibProvider

class TabOneFragment : BaseFragment() {
    private lateinit var binding: FragmentTabOneBinding

    private val employeeViewModel: EmployeeViewModel by navGraphViewModels(R.id.employee_lib_navigation) {
        viewModelFactory
    }

    companion object {
        fun newInstance() = TabOneFragment()
    }

    override fun getViewModel(): BaseViewModel {
        return employeeViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTabOneBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        viewModelFactory = EmployeeLibProvider.provideTabsViewModelFactory()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnHome.setOnClickListener {
            performHomeClick()
        }
    }
}