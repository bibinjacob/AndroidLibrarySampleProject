package emp.example.library.employee.general.home.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import emp.example.library.employee.base.presentation.BaseFragment
import emp.example.library.employee.base.presentation.BaseViewModel
import emp.example.library.employee.base.presentation.EmployeeSession
import emp.example.library.employee.base.presentation.entity.EmployeeLibParams
import emp.example.library.employee.base.presentation.utils.PresentationConstants
import emp.example.library.employee.databinding.FragmentEmployeeHomeBinding
import emp.example.library.employee.di.EmployeeLibProvider

class HomeFragment : BaseFragment() {

    private lateinit var binding: FragmentEmployeeHomeBinding
    private lateinit var employeeLibParams: EmployeeLibParams

    private val homeViewModel: HomeViewModel by activityViewModels {
        viewModelFactory
    }

    override fun getViewModel(): BaseViewModel {
        return homeViewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fetchArguments()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEmployeeHomeBinding.inflate(inflater, container, false)
        viewModelFactory = EmployeeLibProvider.provideEmployeeViewModelFactory()
        binding.employeeHomeViewModel = homeViewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    private fun fetchArguments() {
        arguments?.let {
            employeeLibParams = it.getParcelable(
                PresentationConstants.IntentRequestCode.EMPLOYEE_LIB_REQUEST_PARAMS
            ) ?: employeeLibParams
            EmployeeSession.setEmployeeLibParams(employeeLibParams)
        }
    }
}