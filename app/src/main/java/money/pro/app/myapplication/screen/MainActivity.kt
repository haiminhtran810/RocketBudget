package money.pro.app.myapplication.screen

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import money.pro.app.myapplication.R
import money.pro.app.myapplication.screen.welcomefragment.WelcomeFragment
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }
        supportFragmentManager.beginTransaction().replace(
            R.id.parent,
            WelcomeFragment.newInstance(), WelcomeFragment.TAG
        ).commitNow()
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}
