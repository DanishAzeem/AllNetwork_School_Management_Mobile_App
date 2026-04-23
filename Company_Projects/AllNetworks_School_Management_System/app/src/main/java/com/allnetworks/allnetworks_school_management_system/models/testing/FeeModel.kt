package com.allnetworks.allnetworks_school_management_system.models.testing

import androidx.annotation.Keep

@Keep
data class FeeModel(
    val month: String,
    val amount: String,
    val status: String,
)
