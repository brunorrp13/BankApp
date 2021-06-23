//package com.example.bankapp.presentation.di
//
//import com.example.bankapp.BuildConfig
//import com.example.bankapp.data.api.UserAPIService
//import com.example.tasks.service.constants.TaskConstants
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.components.SingletonComponent
//import okhttp3.Interceptor
//import okhttp3.OkHttpClient
//import okhttp3.Response
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//import javax.inject.Singleton

//@Module
//@InstallIn(SingletonComponent::class)
//class NetModule {
//
//    @Singleton
//    @Provides
//    fun provideUserAPIService(retrofit: Retrofit):UserAPIService{
//        return retrofit.create(UserAPIService::class.java)
//    }


//    @Singleton
//    @Provides
//    fun provideRetrofit(authToken: String? = null): Retrofit {
//        val httpClient = OkHttpClient.Builder()
//        httpClient.addInterceptor(object : Interceptor {
//            override fun intercept(chain: Interceptor.Chain): Response {
//                val request =
//                    chain.request()
//                        .newBuilder()
//                        .addHeader(TaskConstants.HEADER.TOKEN_KEY, authToken)
//                        .build()
//                return chain.proceed(request)
//            }
//        })
//
//        return Retrofit.Builder()
//            .addConverterFactory(GsonConverterFactory.create())
//            .baseUrl(BuildConfig.BASE_URL)
//            .client(httpClient.build())
//            .build()
//
//    }


//
//}













