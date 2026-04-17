package com.allnetworks.allnetworks_school_management_system.utils

import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.DateValidatorPointBackward
import com.google.android.material.datepicker.DateValidatorPointForward
import com.google.android.material.datepicker.MaterialDatePicker
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object DateTimeUtil {

    fun showDatePicker(
        dateFormat: String = "yyyy-MM-dd",
        allowPastDates: Boolean = true,
        allowFutureDates: Boolean = true,
        date: (String) -> Unit
    ) {
        // Define the date format
        val dateFormatter = SimpleDateFormat(dateFormat, Locale.getDefault())

        // Create the CalendarConstraints.Builder
        val constraintsBuilder = CalendarConstraints.Builder()

        // If past dates are not allowed, set the start date to today
        if (!allowPastDates) {
            constraintsBuilder.setValidator(DateValidatorPointForward.now())
        }

        // If future dates are not allowed, set the start date to today
        if (!allowFutureDates) {
            constraintsBuilder.setValidator(DateValidatorPointBackward.now())
        }

        // Apply the constraints to the DatePicker
        val datePicker = MaterialDatePicker.Builder.datePicker()
            .setTitleText("Select a date")
            .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
            .setCalendarConstraints(constraintsBuilder.build())
            .build()

        // Get the FragmentManager
        AppController.navListener?.getMainActivity()?.supportFragmentManager?.let {

            // Show the date picker
            datePicker.show(it, "MATERIAL_DATE_PICKER")

            // Set the positive button click listener
            datePicker.addOnPositiveButtonClickListener { millis ->
                // Get the selected date in milliseconds
                val selectedDateInMillis = millis

                // Convert the milliseconds to a Date object
                val selectedDate = Date(selectedDateInMillis)

                // Format the date to the desired string format
                val formattedDate = dateFormatter.format(selectedDate)

                // Return the formatted date
                date.invoke(formattedDate)
            }
        }
    }

}