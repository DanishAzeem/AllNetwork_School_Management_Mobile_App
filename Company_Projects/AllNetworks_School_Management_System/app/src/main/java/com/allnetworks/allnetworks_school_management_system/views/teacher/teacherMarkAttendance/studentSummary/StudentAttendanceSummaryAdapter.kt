package com.allnetworks.allnetworks_school_management_system.views.teacher.teacherMarkAttendance.studentSummary

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.allnetworks.allnetworks_school_management_system.R
import com.allnetworks.allnetworks_school_management_system.databinding.ItemSummaryStudentAttendanceBinding
import com.allnetworks.allnetworks_school_management_system.models.testing.StudentAttendanceSummaryModel
import com.allnetworks.allnetworks_school_management_system.utils.getInitials

class StudentAttendanceSummaryAdapter() :
    RecyclerView.Adapter<StudentAttendanceSummaryAdapter.StudentAttSummaryViewHolder>() {

    val dataList = mutableListOf<StudentAttendanceSummaryModel>()


    inner class StudentAttSummaryViewHolder(
        val binding: ItemSummaryStudentAttendanceBinding
    ) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(
        parent: ViewGroup,
        p1: Int
    ): StudentAttSummaryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemSummaryStudentAttendanceBinding.inflate(inflater, parent, false)
        return StudentAttSummaryViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: StudentAttSummaryViewHolder,
        position: Int
    ) {
        val item = dataList[position]
        val (avatarBG, avatarText) = colorPairs.random()
//        val (avatarBG, avatarText) = colorPairs[position % colorPairs.size]
        val bgColor = ContextCompat.getColor(holder.itemView.context, avatarBG)
        val teal = ContextCompat.getColor(holder.itemView.context, R.color.teal_text)
        val yellow = ContextCompat.getColor(holder.itemView.context, R.color.yellow)
        val red = ContextCompat.getColor(holder.itemView.context, R.color.red)

        holder.binding.apply {
            tvAvatar.text = getInitials(item.name)
            tvName.text = item.name
            tvStatus.text =
                "${item.attendance}/${item.total_attendance_count}"
            totalStudentsProgressBar.max = item.total_attendance_count
            totalStudentsProgressBar.progress = item.attendance
            tvAvatar.setTextColor(avatarText)
            tvAvatar.backgroundTintList = ColorStateList.valueOf(bgColor)
            tvStatus.backgroundTintList = ColorStateList.valueOf(bgColor)
            val percentage = if (item.total_attendance_count > 0) {
                (item.attendance * 100f) / item.total_attendance_count
            } else 0f
            when {
                percentage >= 80 -> totalStudentsProgressBar.setIndicatorColor(teal)
                percentage >= 50 -> totalStudentsProgressBar.setIndicatorColor(yellow)
                else -> totalStudentsProgressBar.setIndicatorColor(red)
            }

            tvProgressPercentage.text = String.format("%.1f%%", percentage)
        }
        holder.binding.root.setOnClickListener {
            onItemClick?.invoke("clicked")
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    var onItemClick: ((String) -> Unit)? = null
    fun getData(list: List<StudentAttendanceSummaryModel>) {
        dataList.clear()
        dataList.addAll(list)
        notifyDataSetChanged()
    }
    private val colorPairs = listOf(
        Pair(R.color.purple_bg, R.color.purple_text),
        Pair(R.color.green_bg, R.color.green_text),
        Pair(R.color.peach_bg, R.color.peach_text),
        Pair(R.color.blue_bg, R.color.blue_text),
        Pair(R.color.pink_bg, R.color.pink_text),
        Pair(R.color.amber_bg, R.color.amber_text),
        Pair(R.color.teal_bg, R.color.teal_text),
        Pair(R.color.lavender_bg, R.color.lavender_text),
    )

}