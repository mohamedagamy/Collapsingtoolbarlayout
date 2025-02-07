package com.example.profiletask.api
import com.example.profiletask.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object RetrofitBuilder {
    fun getRetrofit(): Retrofit {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = (HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .readTimeout(60,TimeUnit.SECONDS)
            .connectTimeout(60,TimeUnit.SECONDS)
            .addInterceptor(interceptor).build()


        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        return retrofit
    }

    fun getApiService():ApiService{
        return getRetrofit().create(ApiService::class.java)
    }
}