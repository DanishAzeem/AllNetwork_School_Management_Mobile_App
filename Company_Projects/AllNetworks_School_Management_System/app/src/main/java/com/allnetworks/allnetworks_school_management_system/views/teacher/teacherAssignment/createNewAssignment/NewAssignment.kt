package com.allnetworks.allnetworks_school_management_system.views.teacher.teacherAssignment.createNewAssignment

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.allnetworks.allnetworks_school_management_system.R
import com.allnetworks.allnetworks_school_management_system.databinding.FragmentNewAssignmentBinding
import com.allnetworks.allnetworks_school_management_system.utils.AppController
import com.allnetworks.allnetworks_school_management_system.utils.dpToPx

class NewAssignment : Fragment(R.layout.fragment_new_assignment) {
    private lateinit var binding: FragmentNewAssignmentBinding

    val classes = listOf("8B", "9A", "7C")
    var selectedChip: TextView? = null

    private val viewModel by viewModels<NewAssignmentVM>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNewAssignmentBinding.bind(view)
        AppController.navListener?.isLockDrawer(true)
        binding.viewModel = viewModel

        classes.forEach { label ->
            val chip = TextView(context).apply {
                text = label
                textSize = 14f
                setPadding(40, 18, 40, 18)
                setTextColor(ContextCompat.getColor(context, R.color.textColor))
                background = ContextCompat.getDrawable(context, R.drawable.bg_chip_unselected)
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply { marginEnd = 8.dpToPx() }

                setOnClickListener {
                    selectedChip?.background = ContextCompat.getDrawable(context, R.drawable.bg_chip_unselected)
                    selectedChip?.setTextColor(ContextCompat.getColor(context, R.color.textColor))
                    background = ContextCompat.getDrawable(context, R.drawable.bg_chip_selected)
                    setTextColor(ContextCompat.getColor(context, R.color.white))
                    selectedChip = this
                }
            }
            binding.chipGroup.addView(chip)
            if (label == classes.first()) chip.performClick()
        }

    }
    
}