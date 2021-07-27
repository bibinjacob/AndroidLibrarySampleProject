package emp.example.library.employee.base.presentation

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import emp.example.library.employee.base.NavigationCallback

abstract class BaseFragment : Fragment() {
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private var callback: NavigationCallback? = null

    abstract fun getViewModel(): BaseViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObservers()
    }

    protected open fun setObservers() {
    }

    override fun onDestroy() {
        super.onDestroy()
        //To clear all viewModels
        activity?.viewModelStore?.clear()
    }

    //Call back to base app
    fun performHomeClick() {
        activity?.let {
            callback?.onHomePageNavigate()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            callback = context as NavigationCallback
        } catch (e: ClassCastException) {
            throw ClassCastException(
                "$context must implement NavigationCallback"
            )
        }
    }
}