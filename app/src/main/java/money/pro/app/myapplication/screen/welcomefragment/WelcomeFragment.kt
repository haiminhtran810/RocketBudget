package money.pro.app.myapplication.screen.welcomefragment

import android.os.Bundle
import money.pro.app.myapplication.BR
import money.pro.app.myapplication.R
import money.pro.app.myapplication.base.BaseFragment
import money.pro.app.myapplication.databinding.FragmentWelcomeBinding
import org.koin.android.viewmodel.ext.android.viewModel

class WelcomeFragment : BaseFragment<FragmentWelcomeBinding, WelcomeViewModel>(), WelcomeNavigator {
    companion object {
        const val TAG = "WelcomeFragment"
        fun newInstance() = WelcomeFragment()
    }

    override val viewModel: WelcomeViewModel by viewModel<WelcomeViewModel>()

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.fragment_welcome

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewBinding.viewModel = viewModel
        viewModel.apply {
            navigator = this@WelcomeFragment
        }
    }
}