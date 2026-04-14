package com.allnetworks.allnetworks_school_management_system

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.isVisible
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.allnetworks.allnetworks_school_management_system.databinding.ActivityMainBinding
import com.allnetworks.allnetworks_school_management_system.interfaces.NavigationListener
import com.allnetworks.allnetworks_school_management_system.utils.AppController
import com.allnetworks.allnetworks_school_management_system.utils.AppController.Companion.navListener
import com.allnetworks.allnetworks_school_management_system.views.student.assignment.AssignmentVM
import dagger.hilt.android.AndroidEntryPoint
import java.lang.ref.WeakReference
import kotlin.getValue

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), NavigationListener {

    lateinit var binding: ActivityMainBinding

    private val viewModel by viewModels<MainVM>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        AppController.context = WeakReference(this)
        binding.vm = viewModel

        viewModel.navController = findNavController(R.id.fragmentMain)
//        binding.bottomNavigationView.setupWithNavController(viewModel.navController)
        navListener = this
    }

    override fun isLockDrawer(isLock: Boolean) {
        if (isLock) {
            binding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
//            binding.bottomNavigationView.isVisible = false
        } else {
            binding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
//            binding.bottomNavigationView.isVisible = true

        }
    }

    override fun openDrawer() {
        try {
            if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                binding.drawerLayout.closeDrawer(GravityCompat.START)
            } else {
                binding.drawerLayout.openDrawer(GravityCompat.START)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun setNavHost(): NavController {
        viewModel.navController = findNavController(R.id.fragmentMain)
        return viewModel.navController
    }

    override fun getMainVm(): MainVM {
        return viewModel
    }

    override fun getMainActivity(): MainActivity {
        return this
    }

}