package com.allnetworks.allnetworks_school_management_system.views.student.timeTable

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.allnetworks.allnetworks_school_management_system.R
import com.allnetworks.allnetworks_school_management_system.databinding.FragmentTimetableBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TimetableFragment : Fragment(R.layout.fragment_timetable) {

    lateinit var binding: FragmentTimetableBinding

    private var adapter = TimeTableAdapter()
    private var adapter2 = TimeTableAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTimetableBinding.bind(view)

        val data2 = arrayListOf("10:00 AM - 11:00 AM", "10:00 AM - 12:00 PM", "12:00 PM - 1:00 PM", "1:00 PM - 2:00 PM", "2:00 AM - 3:00 PM")
        val data = arrayListOf("Math", "Islamiyat", "Urdu", "English", "Pak Study",)
//        val adapter = ArrayAdapter(requireContext(), R.layout.list_item_timetable_times, R.id.lectureTime, data)

//        val headerView = layoutInflater.inflate(R.layout.list_item_timetable_times, null)

        adapter = TimeTableAdapter(data)
        adapter2 = TimeTableAdapter(data2)

        binding.rv1.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@TimetableFragment.adapter2
        }
        binding.rv2.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@TimetableFragment.adapter
        }
        binding.rv3.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@TimetableFragment.adapter
        }
        binding.rv4.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@TimetableFragment.adapter
        }
        binding.rv5.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@TimetableFragment.adapter
        }
        binding.rv6.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@TimetableFragment.adapter
        }

    }

}