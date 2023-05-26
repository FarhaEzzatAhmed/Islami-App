package com.example.islamii.ApiManager

import android.util.Log
import com.example.islamii.Constans.BASE_URL
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiManager {

    companion object{

        private var retrofit: Retrofit?= null

        private fun getInstance():Retrofit{

            val httpInterceptor =HttpLoggingInterceptor(object :HttpLoggingInterceptor.Logger{
                override fun log(message: String) {
                    Log.e("api",message)
                }
            })
            val okHttpClient = OkHttpClient.Builder().addInterceptor(httpInterceptor).build()

            val gson = GsonBuilder()
                .setLenient()
                .create()

             return retrofit?: Retrofit.Builder()
                 .client(okHttpClient)
                 .addConverterFactory(GsonConverterFactory.create())
                 .baseUrl(BASE_URL).build()
        }

        fun getWepService():WebServices{
            return  getInstance().create(WebServices::class.java)

        }
    }
}