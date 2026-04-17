package com.allnetworks.allnetworks_school_management_system.recycleradapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter<T : AbstractModel>(
    @LayoutRes val layoutId: Int,
    private val isAnimation: Boolean = false,
    val variableId: Int,  // Pass BR.model here

) : RecyclerView.Adapter<RecyclerAdapter.VH<T>>() {

    private val items by lazy { mutableListOf<T>() }

    private var onItemClick: OnItemClick? = null
    private var onItemSwipe: OnItemSwipe? = null

    private var inflater: LayoutInflater? = null
    private val animatedPosition: HashSet<Int> by lazy { HashSet() }

    class VH<T : AbstractModel>(val binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: T, variableId: Int) {
            binding.setVariable(variableId, model)
//            binding.setVariable(BR.model, model)
            binding.executePendingBindings()
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH<T> {
        val layoutInflater = inflater ?: LayoutInflater.from(parent.context)
        val binding =
            DataBindingUtil.inflate<ViewDataBinding>(layoutInflater, layoutId, parent, false)
        return VH(binding)
    }


    override fun onBindViewHolder(holder: VH<T>, position: Int) {
        val model = items[position]
        model.adapterPosition = position
        onItemClick?.let { model.onItemClick = it }
        onItemSwipe?.let { model.onItemSwipe = it }
        model.length = items.size
        model.viewHolder = holder
        model.isLastPosition = position == items.size - 1

        holder.bind(model, variableId)
//        holder.binding.setVariable(BR.model, model)  // BR used here
//        holder.binding.executePendingBindings()
//        if (isAnimation) setAnimation(holder, position)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun interface OnItemClick {
        fun onClick(view: View, position: Int, type: Any)
    }

    fun interface OnItemSwipe {
        fun onClick(view: View, viewHolder: RecyclerView.ViewHolder, item: Any)
    }

    private fun setAnimation(holder: RecyclerView.ViewHolder, position: Int) {
        if (this.animatedPosition.contains(Integer.valueOf(position))) {
            holder.itemView.clearAnimation()
            return
        }
    }

    fun setOnItemClick(onItemClick: OnItemClick) {
        this.onItemClick = onItemClick
    }

    fun getItemAt(index: Int): T {
        return items[index]
    }

    fun getAllItems() = items

    fun addItems(items: List<T>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }


}