package emp.example.library.employee.base.data.network

import emp.example.library.employee.base.data.network.entity.ResponseData
import emp.example.library.employee.employeemanagement.data.model.EmployeeData
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Retrofit class for apis
 * */
internal interface RepoService {

    @GET("employeeData")
    fun getEmployeeData(
        @Query(value = "employeeID", encoded = true) employeeID: String
    ): Single<ResponseData<EmployeeData>>
}
