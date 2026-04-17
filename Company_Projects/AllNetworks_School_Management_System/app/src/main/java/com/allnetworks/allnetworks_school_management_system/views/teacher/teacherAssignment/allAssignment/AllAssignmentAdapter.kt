package com.allnetworks.allnetworks_school_management_system.views.teacher.teacherAssignment.allAssignment

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.allnetworks.allnetworks_school_management_system.R
import com.allnetworks.allnetworks_school_management_system.databinding.ItemTeacherAllAssignmentBinding
import com.allnetworks.allnetworks_school_management_system.models.testing.AllAssignmentModel
import com.allnetworks.allnetworks_school_management_system.utils.AppController

class AllAssignmentAdapter(
    private val dataList: ArrayList<AllAssignmentModel> = ArrayList(),
) : RecyclerView.Adapter<AllAssignmentAdapter.AssignmentViewHolder>() {

    inner class AssignmentViewHolder(
        val binding: ItemTeacherAllAssignmentBinding
    ) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(
        parent: ViewGroup,
        p1: Int
    ): AssignmentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemTeacherAllAssignmentBinding.inflate(inflater, parent, false)
        return AssignmentViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: AssignmentViewHolder,
        position: Int
    ) {
        val item = dataList[position]
        val randomColorRes = colors.random()
        val colors = ContextCompat.getColor(holder.itemView.context, randomColorRes)
        holder.binding.apply {
            teacherClassSubject.text = item.classSubject
            teacherAssignmentTitle.text = item.assignmentDetails
            teacherClassSubject.text = item.classSubject
            teacherClassSection.text = item.classSection
            tvTotalTime.text = item.totalTime
            tvProgressText.text =
                "${item.completedStudents}/${item.totalStudents}"
            totalStudentsProgressBar.max = item.totalStudents
            totalStudentsProgressBar.progress = item.completedStudents
            lyBorder.backgroundTintList = ColorStateList.valueOf(colors)
            totalStudentsProgressBar.setIndicatorColor(colors)
        }
        holder.binding.root.setOnClickListener {
            onItemClick?.invoke("clicked")
        }

    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    var onItemClick: ((String) -> Unit)? = null

    private val colors = listOf(
        R.color.green,
        R.color.purple_200,
        R.color.orange,
        R.color.blue
    )

}