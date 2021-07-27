package emp.example.library.employee.di

import androidx.lifecycle.ViewModelProvider
import emp.example.library.employee.BuildConfig
import emp.example.library.employee.base.data.Constants.NETWORK_CALL_TIMEOUT
import emp.example.library.employee.base.data.network.RepoService
import emp.example.library.employee.base.presentation.EmployeeSession
import emp.example.library.employee.employeemanagement.data.EmployeeRepositoryImpl
import emp.example.library.employee.employeemanagement.domain.EmployeeRepository
import emp.example.library.employee.employeemanagement.domain.EmployeeUseCase
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Contain methods which provides dependencies
 * */
internal object EmployeeLibProvider {
    private fun provideRetrofitService(): RepoService {
        return Retrofit.Builder()
            .baseUrl(EmployeeSession.getBaseUrl())
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(
                        HttpLoggingInterceptor()
                            .apply {
                                level = if (BuildConfig.DEBUG)
                                    HttpLoggingInterceptor.Level.BODY
                                else
                                    HttpLoggingInterceptor.Level.NONE
                            })
                    .readTimeout(NETWORK_CALL_TIMEOUT.toLong(), TimeUnit.SECONDS)
                    .writeTimeout(NETWORK_CALL_TIMEOUT.toLong(), TimeUnit.SECONDS)
                    .build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build().create(RepoService::class.java)
    }

    //------------------------------Repository---------------------------------------------

    private fun provideEmployeeRepository(): EmployeeRepository =
        EmployeeRepositoryImpl(provideRetrofitService())

    //------------------------------UseCase---------------------------------------------

    private fun provideEmployeeUseCase(): EmployeeUseCase =
        EmployeeUseCase(
            provideEmployeeRepository()
        )

    //------------------------------ViewModel---------------------------------------------

    fun provideTabsViewModelFactory(): ViewModelProvider.Factory =
        TabsViewModelFactory(provideEmployeeUseCase())

    fun provideEmployeeViewModelFactory(): ViewModelProvider.Factory =
        EmployeeViewModelFactory()
}