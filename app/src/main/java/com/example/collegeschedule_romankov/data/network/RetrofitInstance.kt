package com.example.collegeschedule_romankov.data.network

import com.example.collegeschedule_romankov.data.api.ScheduleApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://10.0.2.2:5268/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api: ScheduleApi = retrofit.create(ScheduleApi::class.java)
}