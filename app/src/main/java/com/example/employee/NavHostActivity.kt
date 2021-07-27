package com.example.employee

import android.os.Bundle
import emp.example.library.employee.base.NavigationCallback

class NavHostActivity : BaseActivity(), NavigationCallback {
    var navCallback: NavigationCallback? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nav_host_activity)
    }

    override fun onHomePageNavigate() {
        navCallback?.onHomePageNavigate()
    }
}
