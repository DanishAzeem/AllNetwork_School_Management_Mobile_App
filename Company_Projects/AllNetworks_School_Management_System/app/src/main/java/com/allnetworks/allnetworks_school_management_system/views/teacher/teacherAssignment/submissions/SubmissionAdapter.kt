package com.allnetworks.allnetworks_school_management_system.views.teacher.teacherAssignment.submissions

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.allnetworks.allnetworks_school_management_system.R
import com.allnetworks.allnetworks_school_management_system.databinding.ItemSubmissionStudentsBinding
import com.allnetworks.allnetworks_school_management_system.models.testing.AllSubmissionModel

class SubmissionAdapter(
    private val dataList: ArrayList<AllSubmissionModel> = ArrayList(),
) : RecyclerView.Adapter<SubmissionAdapter.SubmissionViewHolder>() {

    inner class SubmissionViewHolder(
        val binding: ItemSubmissionStudentsBinding
    ) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(
        parent: ViewGroup,
        p1: Int
    ): SubmissionViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemSubmissionStudentsBinding.inflate(inflater, parent, false)
        return SubmissionViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: SubmissionViewHolder,
        position: Int
    ) {
        val item = dataList[position]
        val (bgResAvatar, tvtResAvatar) = colorPairs.random()
        val (bgResStatus, tvtResStatus) = colorPairs.random()
        val avatarBgColor = ContextCompat.getColor(holder.itemView.context, bgResAvatar)
        val statusBgColor = ContextCompat.getColor(holder.itemView.context, bgResStatus)

        holder.binding.apply {
            tvAvatar.text = getInitials(item.name)
            tvName.text = item.name
            tvDateAndTime.text = item.timeAndDate
            tvStatus.text = item.status
            tvAvatar.backgroundTintList = ColorStateList.valueOf(avatarBgColor)
            tvStatus.backgroundTintList = ColorStateList.valueOf(statusBgColor)
            tvAvatar.setTextColor(tvtResAvatar)
            tvStatus.setTextColor(tvtResStatus)
        }
        if(getLastElement() == position){
            holder.binding.bottomLine.visibility = View.GONE
        }
        holder.binding.root.setOnClickListener {
            onItemClick?.invoke("clicked")
        }

    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    var onItemClick: ((String) -> Unit)? = null


    fun getLastElement(): Int {
        return dataList.size - 1
    }
    fun getInitials(name: String): String {
        val words = name.trim().split(" ")
        return when {
            words.size >= 2 -> "${words[0].first()}${words[1].first()}".uppercase()
            words.size == 1 -> words[0].take(2).uppercase()
            else -> "?"
        }
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