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
            listOf("Name", "Age", "City", "Roll No", "Address", "Address 2", "Address 3"),
            listOf("Ali", "25", "Lahore", "roll-1230", "abc", "xyz", "mno"),
            listOf("Ahmed", "28", "Karachi", "roll-1230", "abc", "xyz", "mno"),
            listOf("Sara", "22", "Islamabad", "roll-1230", "abc", "xyz", "mno")
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



