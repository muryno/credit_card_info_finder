package com.muryno.cardfinder.model.server

import ApiInterface
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class RetrofitClient {
    companion object{

        val BASE_URL: String = "https://lookup.binlist.net/"



        private   var mInstance: RetrofitClient? = null

        @Synchronized
        fun getInstance(): RetrofitClient? {
            if (mInstance == null) {
                mInstance =
                    RetrofitClient()
            }
            return mInstance
        }
    }
    private var mRetrofit: Retrofit? = null

    init {


        val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val client = OkHttpClient.Builder()
            .readTimeout(3, TimeUnit.MINUTES)
            .connectTimeout(3, TimeUnit.MINUTES)
            .addInterceptor { chain ->
                val newRequest = chain.request().newBuilder()
                    .addHeader("Content-Type", "application/json")
                    .build()
                chain.proceed(newRequest)

            }.addInterceptor(interceptor).build()

        val gson = GsonBuilder()
            .setLenient()
            .create()


        mRetrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
    fun getApi(): ApiInterface? {
        return mRetrofit?.create(ApiInterface::class.java)
    }

    fun reset() {
        mInstance = null
        getInstance()
    }


}