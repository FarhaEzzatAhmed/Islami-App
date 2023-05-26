package com.example.islamii.ApiManager.Models

import com.google.gson.annotations.SerializedName

data class RadioResponse(

	@field:SerializedName("radios")
	val radios: List<RadioChannel?>? = null
)