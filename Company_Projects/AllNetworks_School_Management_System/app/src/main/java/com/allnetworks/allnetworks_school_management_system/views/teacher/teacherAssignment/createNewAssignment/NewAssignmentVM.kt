package com.allnetworks.allnetworks_school_management_system.views.teacher.teacherAssignment.createNewAssignment

import android.os.SystemClock
import android.view.View
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.allnetworks.allnetworks_school_management_system.R
import com.allnetworks.allnetworks_school_management_system.models.DummyModel
import com.allnetworks.allnetworks_school_management_system.recycleradapter.RecyclerAdapter
import com.allnetworks.allnetworks_school_management_system.utils.DateTimeUtil
import com.allnetworks.allnetworks_school_management_system.utils.navigateBack
import com.allnetworks.allnetworks_school_management_system.utils.navigateWithId
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject


@HiltViewModel
class NewAssignmentVM @Inject constructor() : ViewModel() {
    var mLastClickTime: Long = 0

    //    drop-down state
    var itemState: ObservableField<String> = ObservableField("")
    var isDropDownState: ObservableBoolean = ObservableBoolean(false)
    val adapterState = RecyclerAdapter<DummyModel>(R.layout.item_store_type)

    var dueDate: ObservableField<String> = ObservableField("")


    init {
        dummyvalues()
        adapterState.setOnItemClick { view, position, _ ->
            val item = adapterState.getItemAt(position)
            when (view.id) {
                R.id.llCheckBox -> {
                    adapterState.getAllItems().forEach {
                        it.isChecked = false
                    }
                    item.isChecked = !item.isChecked
//                    adapterState.notifyDataSetChanged()
                    itemState.set(item.name)
                    isDropDownState.set(false)
                }
                R.id.layout_back ->{
                    navigateBack()
                }
            }
        }
    }

    fun dummyvalues() {
        adapterState.addItems(
            listOf(
                DummyModel(
                    name = "English"
                ),
                DummyModel(
                    name = "Math"
                ),
                DummyModel(
                    name = "Urdu"
                ),
            )

        )
    }


    fun onClick(view: View) {

        if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
            return
        }
        mLastClickTime = SystemClock.elapsedRealtime()

        when (view.id) {
            R.id.ivBack -> {
                navigateBack()
            }
            R.id.publishAssignmentBtn -> {
                view.navigateWithId(R.id.action_newAssignment_to_allAssignment)
            }

            R.id.et_dueDate -> {
                DateTimeUtil.showDatePicker(allowPastDates = false, allowFutureDates = true) {
                    dueDate.set(it)
                }
            }

//            R.id.spinner_state -> {
//                isDropDownState.set(!isDropDownState.get())
//            }
        }
    }
}