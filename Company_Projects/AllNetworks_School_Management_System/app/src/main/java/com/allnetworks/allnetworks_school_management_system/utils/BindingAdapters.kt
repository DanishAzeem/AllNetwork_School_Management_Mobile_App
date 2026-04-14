package com.allnetworks.allnetworks_school_management_system.utils

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

/** Binding Adapters */
object BindingAdapters {

    @BindingAdapter(value = ["setRecyclerAdapter"], requireAll = false)
    @JvmStatic
    fun setRecyclerAdapter(
        recyclerView: RecyclerView,
        adapter: RecyclerView.Adapter<*>?,
    ) {
        recyclerView.adapter = adapter
    }
}