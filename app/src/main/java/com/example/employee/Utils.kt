package com.example.employee

import emp.example.library.employee.base.presentation.entity.EmployeeLibParams

fun getEmployeeLibParams(userID:String): EmployeeLibParams {
    return EmployeeLibParams(
        baseUrl = BuildConfig.BASE_URL,
        userID = userID
    )
}