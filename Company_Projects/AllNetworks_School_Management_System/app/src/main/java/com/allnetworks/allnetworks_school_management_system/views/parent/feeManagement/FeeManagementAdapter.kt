package com.allnetworks.allnetworks_school_management_system.views.parent.feeManagement
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.allnetworks.allnetworks_school_management_system.R
import com.allnetworks.allnetworks_school_management_system.databinding.ItemFeeBinding
import com.allnetworks.allnetworks_school_management_system.models.testing.FeeModel

class FeeManagementAdapter(
) : RecyclerView.Adapter<FeeManagementAdapter.FeeSubmissionViewHolder>() {

    private val dataList = arrayListOf<FeeModel>()


    inner class FeeSubmissionViewHolder(
        val binding: ItemFeeBinding
    ) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(
        parent: ViewGroup,
        p1: Int
    ): FeeSubmissionViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemFeeBinding.inflate(inflater, parent, false)
        return FeeSubmissionViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: FeeSubmissionViewHolder,
        position: Int
    ) {
        val item = dataList[position]

        holder.binding.apply {
            tvName.text = item.month
            amount.text = item.amount
            tvStatus.text = item.status
            if(tvStatus.text == "pending") {
                tvStatus.setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.red))
            }
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

    fun getData(list: List<FeeModel>) {
        dataList.clear()
        dataList.addAll(list)
        notifyDataSetChanged()
    }


}