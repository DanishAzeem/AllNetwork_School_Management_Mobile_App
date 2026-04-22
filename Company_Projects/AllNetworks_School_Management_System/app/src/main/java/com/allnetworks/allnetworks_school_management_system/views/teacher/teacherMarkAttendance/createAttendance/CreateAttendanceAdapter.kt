package com.allnetworks.allnetworks_school_management_system.views.teacher.teacherMarkAttendance.createAttendance

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.allnetworks.allnetworks_school_management_system.R
import com.allnetworks.allnetworks_school_management_system.databinding.ItemStudentsListBinding
import com.allnetworks.allnetworks_school_management_system.models.testing.StudentAttendanceListModel
import com.allnetworks.allnetworks_school_management_system.utils.getInitials
import kotlin.math.absoluteValue

class CreateAttendanceAdapter() :
    RecyclerView.Adapter<CreateAttendanceAdapter.ItemStudentsListViewHolder>() {

    val dataList = mutableListOf<StudentAttendanceListModel>()

    inner class ItemStudentsListViewHolder(
        val binding: ItemStudentsListBinding
    ) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(
        parent: ViewGroup,
        p1: Int
    ): ItemStudentsListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemStudentsListBinding.inflate(inflater, parent, false)
        return ItemStudentsListViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ItemStudentsListViewHolder,
        position: Int
    ) {
        val item = dataList[position]
        val index = item.name.hashCode().absoluteValue % colorPairs.size
        val (bgResAvatar, tvtResAvatar) = colorPairs[index]
//        val (bgResAvatar, tvtResAvatar) = colorPairs.random()
        val avatarColor = ContextCompat.getColor(holder.itemView.context, bgResAvatar)
        holder.binding.apply {
            tvAvatar.text = getInitials(item.name)
            tvName.text = item.name
            tvRollNo.text = item.rollNo
            tvAvatar.setTextColor(tvtResAvatar)
            tvAvatar.backgroundTintList = ColorStateList.valueOf(avatarColor)

            tvPresent.setOnClickListener {
                item.isPresent = true
                notifyItemChanged(position)
            }
            tvAbsent.setOnClickListener {
                item.isPresent = false
                notifyItemChanged(position)
            }

            when (item.isPresent) {

                true -> {
                    // Present selected
                    tvPresent.setBackgroundResource(R.drawable.bg_chip_selected)
                    tvPresent.setTextColor(ContextCompat.getColor(root.context, R.color.white))

                    tvAbsent.setBackgroundResource(R.drawable.bg_chip_unselected)
                    tvAbsent.setTextColor(ContextCompat.getColor(root.context, R.color.textColor))
                }
                false -> {
                    // Absent selected
                    tvAbsent.setBackgroundResource(R.drawable.bg_chip_selected)
                    tvAbsent.setTextColor(ContextCompat.getColor(root.context, R.color.white))

                    tvPresent.setBackgroundResource(R.drawable.bg_chip_unselected)
                    tvPresent.setTextColor(ContextCompat.getColor(root.context, R.color.textColor))
                }
                null -> {
                    // 👈 DEFAULT (nothing selected)
                    tvPresent.setBackgroundResource(R.drawable.bg_chip_unselected)
                    tvPresent.setTextColor(ContextCompat.getColor(root.context, R.color.textColor))

                    tvAbsent.setBackgroundResource(R.drawable.bg_chip_unselected)
                    tvAbsent.setTextColor(ContextCompat.getColor(root.context, R.color.textColor))
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    var onItemClick: ((String) -> Unit)? = null
    fun getData(list: List<StudentAttendanceListModel>) {
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