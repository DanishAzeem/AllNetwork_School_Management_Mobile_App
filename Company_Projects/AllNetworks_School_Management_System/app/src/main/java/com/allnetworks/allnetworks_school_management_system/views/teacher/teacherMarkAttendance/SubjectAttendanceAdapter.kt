package com.allnetworks.allnetworks_school_management_system.views.teacher.teacherMarkAttendance

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.allnetworks.allnetworks_school_management_system.databinding.ItemBgWeekDaysBinding
import com.allnetworks.allnetworks_school_management_system.models.testing.LectureDetails
import com.allnetworks.allnetworks_school_management_system.models.testing.SubjectsAttendanceState

class SubjectAttendanceAdapter(
    private val onLectureClick: (LectureDetails) -> Unit

) : RecyclerView.Adapter<SubjectAttendanceAdapter.SubjectAttendanceViewHolder>() {
    val items = mutableListOf<SubjectsAttendanceState>()

    inner class SubjectAttendanceViewHolder(
        val binding: ItemBgWeekDaysBinding
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        p1: Int
    ): SubjectAttendanceViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBgWeekDaysBinding.inflate(inflater, parent, false)
        return SubjectAttendanceViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SubjectAttendanceViewHolder, position: Int) {
        val item = items[position]

        with(holder.binding) {

            tvWeekDays.text = item.weeks

            // ✅ IMPORTANT: reuse adapter properly
            if (rvLectures.adapter == null) {

                rvLectures.layoutManager = LinearLayoutManager(
                    root.context,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )

                rvLectures.adapter = LectureAdapter(onLectureClick)
            }

            val adapter = rvLectures.adapter as LectureAdapter
            adapter.submitList(item.list)
        }
    }


    override fun getItemCount(): Int {
        return items.size
    }

    var onItemClick: ((String) -> Unit)? = null

    fun getData(list: List<SubjectsAttendanceState>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

}
