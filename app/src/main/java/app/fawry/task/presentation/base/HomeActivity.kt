package app.fawry.task.presentation.base

import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.*
import com.structure.base_mvvm.R
import com.structure.base_mvvm.databinding.ActivityHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivity<ActivityHomeBinding>() {
  private lateinit var appBarConfiguration: AppBarConfiguration
  private lateinit var nav: NavController

  override
  fun getLayoutId() = R.layout.activity_home

  override
  fun setUpBottomNavigation() {
    setUpBottomNavigationWithGraphs()
  }

  private  val TAG = "HomeActivity"

  private fun setUpBottomNavigationWithGraphs() {
    val navHostFragment =
      supportFragmentManager.findFragmentById(R.id.fragment_host_container) as NavHostFragment
    nav = navHostFragment.findNavController()
    appBarConfiguration = AppBarConfiguration(nav.graph)
    setSupportActionBar(binding.toolbar)
    binding.toolbar.setupWithNavController(nav, appBarConfiguration)
  }

  override fun onSupportNavigateUp(): Boolean {
    onBackPressed()
    return true
  }


}