package com.allnetworks.allnetworks_school_management_system.views.parent.feeManagement

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.allnetworks.allnetworks_school_management_system.R
import com.allnetworks.allnetworks_school_management_system.databinding.FragmentFeeManagementBinding
import com.allnetworks.allnetworks_school_management_system.models.testing.FeeModel
import com.allnetworks.allnetworks_school_management_system.utils.AppController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FeeManagement : Fragment(R.layout.fragment_fee_management) {
    lateinit var binding: FragmentFeeManagementBinding
    private val viewModel by viewModels<FeeManagementVM>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFeeManagementBinding.bind(view)
        AppController.navListener?.isLockDrawer(true)
        binding.viewModel = viewModel

        val fakeData = listOf(
            FeeModel(
                "Aug 2025 — Monthly",
                "PKR 8,500",
                "Paid"
            ),
            FeeModel(
                "Sep 2025 — Monthly ",
                "PKR 8,500 ",
                "Paid"
            ),
            FeeModel(
                "Annual Fund ",
                "PKR 5,000 · Oct 2025 ",
                "Pending"
            ),
            FeeModel(
                "Apr 2026 — Monthly",
                "PKR 5,000 · Oct 2025 ",
                "Paid"
            ),
            FeeModel(
                "May 2026 — Monthly ",
                "PKR 5,000 · Oct 2025 ",
                "Paid"
            ),
        )

        val adapter = FeeManagementAdapter()

        binding.rvFees.apply {
            layoutManager = LinearLayoutManager(requireContext())
            this.adapter = adapter
        }
        adapter.getData(fakeData)

    }
}



