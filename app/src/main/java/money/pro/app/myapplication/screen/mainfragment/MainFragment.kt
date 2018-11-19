package money.pro.app.myapplication.screen.mainfragment

import android.os.Bundle
import money.pro.app.myapplication.BR
import money.pro.app.myapplication.R
import money.pro.app.myapplication.base.BaseFragment
import money.pro.app.myapplication.databinding.FragmentMainBinding
import org.koin.android.viewmodel.ext.android.viewModel

class MainFragment : BaseFragment<FragmentMainBinding, MainFragmentViewModel>() {
    companion object {
        const val TAG = "MainFragment"
        fun newInstance()=MainFragment()
    }
    override val viewModel: MainFragmentViewModel by viewModel<MainFragmentViewModel>()
    override val bindingVariable: Int
        get() = BR.viewModel
    override val layoutId: Int
        get() = R.layout.fragment_main

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}