package com.allnetworks.allnetworks_school_management_system.views.signUpProcess

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.core.graphics.toColorInt
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.allnetworks.allnetworks_school_management_system.R
import com.allnetworks.allnetworks_school_management_system.databinding.FragmentSigninBinding
import com.allnetworks.allnetworks_school_management_system.utils.AppController
import com.google.android.material.card.MaterialCardView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SigninFragment : Fragment(R.layout.fragment_signin) {
    private lateinit var binding: FragmentSigninBinding
    private val viewModel by viewModels<SignInVM>()
    private val activeCardBg = "#332e21".toColorInt()
    private val inactiveCardBg = "#2a2619".toColorInt()
    private val activeStroke = "#c9a84c".toColorInt()
    private val inactiveStroke = "#4a4330".toColorInt()
    private val activeTextColor = "#f0e8cc".toColorInt()
    private val inactiveTextColor = "#b0a070".toColorInt()
    private val activeIconBg = "#4a4220".toColorInt()
    private val inactiveIconBg = "#3e3826".toColorInt()
    private val activeIconStroke = "#c9a84c".toColorInt()
    private val inactiveIconStroke = "#5a5135".toColorInt()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSigninBinding.bind(view)
//        binding.viewModel = viewModel
        binding.viewModel = viewModel

//        binding.loginBtn.setOnClickListener {
//            Toast.makeText(context, "NASDAQ", Toast.LENGTH_LONG).show()
////            findNavController().navigate(R.id.action_signInFragment_to_homeFragment)
//        }

        binding.cardParent.setOnClickListener {
            selectRole("Parent")
        }
        binding.cardStudent.setOnClickListener {
            selectRole("Student")
        }
        binding.cardTeacher.setOnClickListener {
            selectRole("Teacher")
        }
    }

    private fun selectRole(role: String) {
        AppController.userRole.set(role)
        setCardState(
            binding.cardParent,
            binding.barParent,
            binding.tvParent,
            binding.iconParent,
            role == "Parent"
        )

        setCardState(
            binding.cardStudent,
            binding.barStudent,
            binding.tvStudent,
            binding.iconStudent,
            role == "Student"
        )

        setCardState(
            binding.cardTeacher,
            binding.barTeacher,
            binding.tvTeacher,
            binding.iconTeacher,
            role == "Teacher"
        )

    }

    private fun setCardState(
        card: MaterialCardView,
        bar: View,
        textView: TextView,
        iconCard: MaterialCardView,
        isActive: Boolean
    ) {
        card.setCardBackgroundColor(if (isActive) activeCardBg else inactiveCardBg)
        card.strokeColor = if (isActive) activeStroke else inactiveStroke
        bar.visibility = if (isActive) View.VISIBLE else View.GONE

        textView.setTextColor(if (isActive) activeTextColor else inactiveTextColor)

        iconCard.setCardBackgroundColor(if (isActive) activeIconBg else inactiveIconBg)
        iconCard.strokeColor = if (isActive) activeIconStroke else inactiveIconStroke
    }

    override fun onResume() {
        super.onResume()
        AppController.navListener?.isLockDrawer(true)
    }

}