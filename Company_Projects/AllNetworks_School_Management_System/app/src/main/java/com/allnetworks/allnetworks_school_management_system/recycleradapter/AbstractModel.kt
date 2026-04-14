package com.allnetworks.allnetworks_school_management_system.recycleradapter

import androidx.recyclerview.widget.RecyclerView

abstract class AbstractModel {
    @Transient
    var adapterPosition: Int = -1

    @Transient
    var vpPosition: Int = -1

    @Transient
    var onItemClick: RecyclerAdapter.OnItemClick? = null

    @Transient
    var onItemSwipe: RecyclerAdapter.OnItemSwipe? = null

    @Transient
    var isLastPosition: Boolean = false

    @Transient
    var viewHolder: RecyclerView.ViewHolder? = null

    @Transient
    var length: Int = -1


}