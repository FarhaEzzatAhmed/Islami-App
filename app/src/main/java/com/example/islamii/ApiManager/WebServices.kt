package com.example.islamii.ApiManager

import com.example.islamii.ApiManager.Models.RadioResponse
import retrofit2.Call
import retrofit2.http.GET

interface WebServices {
@GET("radios")
fun getRadioChannels(): Call<RadioResponse>
}