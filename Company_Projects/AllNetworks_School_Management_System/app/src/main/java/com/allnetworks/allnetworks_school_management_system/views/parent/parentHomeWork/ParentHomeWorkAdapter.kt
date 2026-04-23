package com.allnetworks.allnetworks_school_management_system.views.parent.parentHomeWork

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.allnetworks.allnetworks_school_management_system.databinding.ItemParentHomeWorkBinding
import com.allnetworks.allnetworks_school_management_system.models.testing.ParentHomeWorkModel

class ParentHomeWorkAdapter(
) : RecyclerView.Adapter<ParentHomeWorkAdapter.ParentHomeWorkViewHolder>() {
    private val dataList = arrayListOf<ParentHomeWorkModel>()

    inner class ParentHomeWorkViewHolder(
        val binding: ItemParentHomeWorkBinding
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        p1: Int
    ): ParentHomeWorkViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemParentHomeWorkBinding.inflate(inflater, parent, false)
        return ParentHomeWorkViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ParentHomeWorkViewHolder,
        position: Int
    ) {
        val item = dataList[position]

        holder.binding.apply {
            tvName.text = item.title
            tvDateAndTime.text = item.date
            tvSubject.text = item.subject
        }
        if (getLastElement() == position) {
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

    fun getData(list: List<ParentHomeWorkModel>) {
        dataList.clear()
        dataList.addAll(list)
        notifyDataSetChanged()
    }


}