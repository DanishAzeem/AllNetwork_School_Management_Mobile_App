package com.allnetworks.allnetworks_school_management_system.views.teacher.teacherAssignment.submissions.gradeSubmission

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.allnetworks.allnetworks_school_management_system.R
import com.allnetworks.allnetworks_school_management_system.databinding.FragmentGradeSubmissionBinding

class GradeSubmission : Fragment(R.layout.fragment_grade_submission) {

    lateinit var binding: FragmentGradeSubmissionBinding

    private var totalMarks: Int = 100
    private var marks: Int = 0

    private val viewModel by viewModels<GradeSubmissionVM>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentGradeSubmissionBinding.bind(view)
        binding.viewModel = viewModel

        // Initial value from EditText
        marks = binding.tvTotalMarks.text.toString().toIntOrNull() ?: 0

        binding.totalMarksProgressbar.max = totalMarks

        setupEditText()
        setupButtons()
        updateUI()
    }

    private fun setupEditText() {
        binding.tvTotalMarks.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val value = s.toString().toIntOrNull() ?: return

                marks = value

                // restrict max
                if (marks > totalMarks) {
                    marks = totalMarks
                    binding.tvTotalMarks.setText(totalMarks.toString())
                    binding.tvTotalMarks.setSelection(binding.tvTotalMarks.text.length)
                }

                updateUI()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }

    private fun setupButtons() {

        binding.tvMinus.setOnClickListener {
            if (marks > 0) {
                marks--
                updateUI()
            }
        }

        binding.tvPlus.setOnClickListener {
            if (marks < totalMarks) {
                marks++
                updateUI()
            }
        }
    }
    private fun updateUI() {

        // prevent infinite loop
        if (binding.tvTotalMarks.text.toString() != marks.toString()) {
            binding.tvTotalMarks.setText(marks.toString())
            binding.tvTotalMarks.setSelection(binding.tvTotalMarks.text.length)
        }

        val percentage = if (totalMarks > 0)
            (marks.toFloat() / totalMarks) * 100
        else 0f

        binding.tvMarksPercentage.text = "${percentage.toInt()}%"
        binding.totalMarksProgressbar.progress = marks
    }

}