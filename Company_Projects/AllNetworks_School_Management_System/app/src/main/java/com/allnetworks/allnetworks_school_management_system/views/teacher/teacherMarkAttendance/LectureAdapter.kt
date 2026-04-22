package com.allnetworks.allnetworks_school_management_system.views.teacher.teacherMarkAttendance

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.allnetworks.allnetworks_school_management_system.databinding.ItemLectureBinding
import com.allnetworks.allnetworks_school_management_system.models.testing.LectureDetails

class LectureAdapter(
    private val onItemClick: (LectureDetails) -> Unit
) : RecyclerView.Adapter<LectureAdapter.LectureViewHolder>(

) {
    private val items = mutableListOf<LectureDetails>()

    inner class LectureViewHolder(val binding: ItemLectureBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LectureViewHolder {
        val binding = ItemLectureBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return LectureViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LectureViewHolder, position: Int) {
        val item = items[position]

        with(holder.binding) {
            tvLectureCount.text = "Lecture ${position + 1}"
            tvSubject.text = item.subject
            tvTiming.text = item.date

            root.setOnClickListener {
                onItemClick(item)   // 🔥 callback to parent
            }
        }
    }

    override fun getItemCount() = items.size

    fun submitList(list: List<LectureDetails>) {
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }
}