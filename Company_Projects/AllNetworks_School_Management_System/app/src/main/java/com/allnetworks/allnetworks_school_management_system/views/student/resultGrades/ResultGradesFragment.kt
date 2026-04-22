package com.allnetworks.allnetworks_school_management_system.views.student.resultGrades

import android.os.Bundle
import android.view.View
import android.widget.TableRow
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ComplexColorCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.allnetworks.allnetworks_school_management_system.R
import com.allnetworks.allnetworks_school_management_system.databinding.FragmentResultGradesBinding
import com.allnetworks.allnetworks_school_management_system.utils.AppController

class ResultGradesFragment : Fragment(R.layout.fragment_result_grades) {
    lateinit var binding: FragmentResultGradesBinding
    private val viewModel by viewModels<ResultGradesVM>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentResultGradesBinding.bind(view)
        AppController.navListener?.isLockDrawer(true)
        binding.viewModel = viewModel

        val data = listOf(
            listOf("Sr. #", "Course Code", "Course Name", "Marks Obtained", "Grade Point", "Credit Hours", "Total GP"),

            listOf("1", "CS 102 (N)", "Introduction to Information Communication Technology (Lab)", "85", "4.00", "1", "4.00"),
            listOf("2", "CS 102 (N)", "Introduction to Information Communication Technology", "75", "3.30", "2", "6.60"),
            listOf("3", "CS 103", "Programming Fundamentals (Lab)", "85", "4.00", "1", "4.00"),
            listOf("4", "CS 103", "Programming Fundamentals", "90", "4.00", "3", "12.00"),
            listOf("5", "ENG 100", "English I (Functional English)", "58", "2.00", "3", "6.00"),
            listOf("6", "ISL 101", "Islamic Studies", "75", "3.30", "2", "6.60"),
            listOf("7", "Life-1", "Life and Learning I", "73", "3.00", "1", "3.00"),
            listOf("8", "MT 104", "Calculus & Analytical Geometry", "93", "4.00", "3", "12.00"),
            listOf("9", "PHY 105", "Applied Physics", "89", "4.00", "3", "12.00"),

            listOf("GPA: 3.48", "723/900", "19", "", "", "", "66.20")
        )
        addTable(data)
    }

    fun addTable(data: List<List<String>>) {
        binding.tableLayout.removeAllViews()

        data.forEach { rowData ->
            val row = TableRow(context)

            rowData.forEach { cell ->
                val tv = TextView(context)
                tv.text = cell
                tv.setPadding(12, 12, 12, 12)
                tv.setBackgroundResource(R.drawable.ic_rectangle2)
                context?.let { tv.setTextColor(ContextCompat.getColor(it, R.color.black)) }
                row.addView(tv)
            }
            binding.tableLayout.addView(row)
        }
    }
}



