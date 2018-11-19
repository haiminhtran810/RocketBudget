package money.pro.app.myapplication.screen.homefragment

import android.os.Bundle
import money.pro.app.myapplication.BR
import money.pro.app.myapplication.R
import money.pro.app.myapplication.base.BaseFragment
import money.pro.app.myapplication.databinding.FragmentHomeBinding
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {
    companion object {
        const val TAG = "HomeFragment"
        fun instance() = HomeFragment()
    }
    override val viewModel: HomeViewModel by viewModel<HomeViewModel>()
    override val bindingVariable: Int
        get() = BR.viewModel
    override val layoutId: Int
        get() = R.layout.fragment_home

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}