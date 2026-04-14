package com.allnetworks.allnetworks_school_management_system.models

import android.graphics.drawable.Drawable
import androidx.annotation.Keep
import com.allnetworks.allnetworks_school_management_system.recycleradapter.AbstractModel
import java.io.Serializable

@Keep
data class DummyModel(
    var isPast: Boolean = false,

    var isBookingCompleted: Boolean = false,

    var walkThroughTitle: String? = null,
    var walkThroughDesc: String? = null,
    var walkThroughImage: Drawable? = null,

    var string: String = "",
    var stringSigned: String = "",
    var emit: Int = 0,
    var nextTextButton: String = "",
    var addressId: String = "",
    var name: String = "",
    var isChecked: Boolean = false,
    var elementId: Int = 0,
    var isAttachment: Int = 0,
    var serviceId: Int = 0,
) : AbstractModel(), Serializable

//@Keep
//data class DummyModel(
//    var isPast: Boolean = false,
//
//    var isBookingCompleted: Boolean = false,
//
//    var walkThroughTitle: String? = null,
//    var walkThroughDesc: String? = null,
//    var walkThroughImage: Drawable? = null,
//
//    var string: String = "",
//    var stringSigned: String = "",
//    var emit: Int = 0,
//    var nextTextButton: String = "",
//    var addressId: String = "",
//    var name: String = "",
//    var isChecked: Boolean = false,
//    var elementId: Int = 0,
//    var isAttachment: Int = 0,
//    var serviceId: Int = 0,
//    ) : AbstractModel(), Serializable
