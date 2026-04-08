package com.allnetworks.allnetworks_school_management_system.views.student.timeTable

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.allnetworks.allnetworks_school_management_system.databinding.ItemTimetableTimesBinding

class TimeTableAdapter(
    private val dataList: ArrayList<String> = arrayListOf("1", "2", "3"),
    ) : RecyclerView.Adapter<TimeTableAdapter.TimeTableViewHolder>() {
    inner class TimeTableViewHolder(
        val binding: ItemTimetableTimesBinding
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimeTableViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemTimetableTimesBinding.inflate(inflater, parent, false)
        return TimeTableViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TimeTableViewHolder, position: Int) {
        val item = dataList[position]
        holder.binding.lectureTime.text = item
    }

    override fun getItemCount(): Int {
        return dataList.size
    }




}