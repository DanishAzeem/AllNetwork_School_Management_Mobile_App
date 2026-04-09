package com.allnetworks.allnetworks_school_management_system.views.student.attendance

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.allnetworks.allnetworks_school_management_system.databinding.ItemAssignmentsBinding
import com.allnetworks.allnetworks_school_management_system.databinding.ItemAttendanceListBinding

class AttendanceAdapter(
    private val dataList: ArrayList<String> = arrayListOf("1", "2", "3"),
) : RecyclerView.Adapter<AttendanceAdapter.AttendanceViewHolder>() {

    inner class AttendanceViewHolder(
        val binding: ItemAttendanceListBinding
    ) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(
        parent: ViewGroup,
        p1: Int
    ): AttendanceViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemAttendanceListBinding.inflate(inflater, parent, false)
        return AttendanceViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: AttendanceViewHolder,
        position: Int
    ) {
        val item = dataList[position]
        holder.binding.tvDay.text = item
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

}