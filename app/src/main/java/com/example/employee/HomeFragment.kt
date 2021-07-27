package com.example.employee

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.employee.databinding.FragmentHomeBinding
import emp.example.library.employee.base.NavigationCallback

class HomeFragment : Fragment(), NavigationCallback {

    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnEmployeeData.setOnClickListener {
            startEmployeeLib()
        }
    }

    private fun startEmployeeLib() {
        val employeeLibParams =
            getEmployeeLibParams(userID = "1234")
        val bundle =
            bundleOf(getString(R.string.library_params) to employeeLibParams)
        findNavController().navigate(R.id.action_homeFragment_to_employeeHomeFragment, bundle)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is NavHostActivity) {
            context.navCallback = this
        }
    }

    override fun onHomePageNavigate() {
        findNavController().navigate(R.id.navigate_to_home)
    }
}


