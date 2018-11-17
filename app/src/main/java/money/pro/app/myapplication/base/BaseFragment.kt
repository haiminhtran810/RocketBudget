package money.pro.app.myapplication.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import money.pro.app.myapplication.R

abstract class BaseFragment<ViewBinding : ViewDataBinding, ViewModel : BaseViewModel<*>> : Fragment(), BaseNavigator {

    lateinit var viewBinding: ViewBinding

    abstract val viewModel: ViewModel

    abstract val bindingVariable: Int

    // get layout id
    @get:LayoutRes
    abstract val layoutId: Int

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.apply {
            //https://developer.android.com/reference/android/databinding/ViewDataBinding
            setVariable(bindingVariable, viewModel)
            setLifecycleOwner(this@BaseFragment)
            root.isClickable = false
            // chưa biết thằng này xử lý thế nào
            executePendingBindings()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.onActivityDestroy()
    }

    override fun onBack() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /**
     * fragment transaction
     */
    fun findFragment(TAG: String): Fragment? {
        return activity?.supportFragmentManager?.findFragmentByTag(TAG)
    }

    fun findChildFragment(parentFragment: Fragment = this, TAG: String): Fragment? {
        return parentFragment.childFragmentManager.findFragmentByTag(TAG)
    }

    fun replaceFragment(
        fragment: Fragment, TAG: String?, addToBackStack: Boolean = false,
        transit: Int = -1
    ) {
        val transaction = activity!!.supportFragmentManager!!.beginTransaction()
            .replace(R.id.parent, fragment, TAG)
        commitTransaction(transaction, addToBackStack, transit)
    }

    fun replaceChildFragment(
        parentFragment: Fragment = this, containerViewId: Int, fragment: Fragment,
        TAG: String?, addToBackStack: Boolean = false, transit: Int = -1
    ) {
        val transaction = parentFragment.childFragmentManager.beginTransaction().replace(
            containerViewId, fragment, TAG
        )
        commitTransaction(transaction, addToBackStack, transit)
    }

    fun commitTransaction(
        transaction: FragmentTransaction?, addToBackStack: Boolean,
        transit: Int
    ) {
        if (addToBackStack) transaction?.addToBackStack(null)
        //Select a standard transition animation for this transaction.
        // May be one of TRANSIT_NONE, TRANSIT_FRAGMENT_OPEN, TRANSIT_FRAGMENT_CLOSE, or TRANSIT_FRAGMENT_FADE.
        if (transit != -1) transaction?.setTransition(transit)
        transaction?.commit()
    }

    fun addChildFragment(
        parentFragment: Fragment = this, containerViewId: Int,
        targetFragment: Fragment, TAG: String?, addToBackStack: Boolean = false,
        transit: Int = -1
    ) {
        val transaction = parentFragment.childFragmentManager.beginTransaction().add(
            containerViewId, targetFragment, TAG
        )
        commitTransaction(transaction, addToBackStack, transit)
    }

    // lấy fragment trong stack ra ngoài
    fun popChildFragment(parentFragment: Fragment = this) {
        parentFragment.childFragmentManager.popBackStack()
    }
}