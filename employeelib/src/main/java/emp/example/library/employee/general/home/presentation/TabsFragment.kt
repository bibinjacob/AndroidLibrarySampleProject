package emp.example.library.employee.general.home.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import emp.example.library.employee.R
import emp.example.library.employee.base.presentation.BaseFragment
import emp.example.library.employee.base.presentation.BaseViewModel
import emp.example.library.employee.databinding.FragmentTabsBinding
import emp.example.library.employee.di.EmployeeLibProvider

class TabsFragment : BaseFragment() {
    private lateinit var binding: FragmentTabsBinding
    private var fragmentList = listOf<Fragment>()
    private val tabsViewModel: TabsViewModel by viewModels {
        viewModelFactory
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTabsBinding.inflate(inflater, container, false)
        viewModelFactory = EmployeeLibProvider.provideEmployeeViewModelFactory()
        binding.tabViewModel = tabsViewModel

        binding.executePendingBindings()
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        binding.viewPager.adapter = createViewPagerAdapter()
        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
        })

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            setTabMenuForEmployee(tab, position)
            binding.viewPager.setCurrentItem(tab.position, true)

        }.attach()

        binding.viewPager.offscreenPageLimit = 1
        setListeners()
    }

    private fun setListeners() {
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {}

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabSelected(tab: TabLayout.Tab?) {
                val pos = tab?.position
                pos?.let {
                    binding.viewPager.currentItem = pos
                }
            }
        })
    }

    private fun setTabMenuForEmployee(tab: TabLayout.Tab, position: Int) {
        when (position) {
            0 -> {
                tab.text = getString(R.string.tab1)
            }
            1 -> {
                tab.text = getString(R.string.tab2)
            }
        }
    }

    override fun getViewModel(): BaseViewModel {
        return tabsViewModel
    }

    private fun createViewPagerAdapter(): ViewPagerFragmentAdapter {
        fragmentList = tabsViewModel.getFragmentListForViewpager()
        return ViewPagerFragmentAdapter(this, fragmentList)
    }
}