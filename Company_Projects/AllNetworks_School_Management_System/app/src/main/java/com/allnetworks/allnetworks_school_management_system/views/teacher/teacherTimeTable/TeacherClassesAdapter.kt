package com.allnetworks.allnetworks_school_management_system.views.teacher.teacherTimeTable

import android.content.Context
import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.allnetworks.allnetworks_school_management_system.R
import com.allnetworks.allnetworks_school_management_system.databinding.ItemAssignmentsBinding
import com.allnetworks.allnetworks_school_management_system.databinding.ItemTeacherClassesScheduleBinding
import com.allnetworks.allnetworks_school_management_system.utils.AppController
import com.allnetworks.allnetworks_school_management_system.utils.AppController.Companion.context

class TeacherClassesAdapter(
    private val dataList: ArrayList<String> = arrayListOf("1", "2", "3", "1", "2", "3", "1", "2", "3"),
) : RecyclerView.Adapter<TeacherClassesAdapter.TeacherClassViewHolder>() {

    inner class TeacherClassViewHolder(
        val binding: ItemTeacherClassesScheduleBinding
    ) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(
        parent: ViewGroup,
        p1: Int
    ): TeacherClassViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemTeacherClassesScheduleBinding.inflate(inflater, parent, false)
        return TeacherClassViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: TeacherClassViewHolder,
        position: Int
    ) {
        val item = dataList[position]
        holder.binding.teacherClassTime.text = item
        val randomColorRes = colors.random()
//        val color = context.getColor(randomColorRes)
//        holder.binding.lyBorder.setBackgroundColor(randomColorRes)
//        holder.binding.tvTotalTime.setBackgroundColor(randomColorRes)
//        holder.binding.tvTotalTime.backgroundTintList.

        holder.binding.tvTotalTime.backgroundTintList = ColorStateList.valueOf(
            ContextCompat.getColor(holder.itemView.context, randomColorRes)
        )
        holder.binding.lyBorder.backgroundTintList = ColorStateList.valueOf(
            ContextCompat.getColor(holder.itemView.context, randomColorRes)
        )

    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    private val colors = listOf(
        R.color.green,
        R.color.purple_200,
        R.color.orange,
        R.color.blue
    )

}