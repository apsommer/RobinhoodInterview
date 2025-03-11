package com.sommerengineering.robinhoodinterview

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val baseUrl = "https://gist.githubusercontent.com/dns-mcdaid/b248c852b743ad960616bac50409f0f0/raw/6921812bfb76c1bea7868385adf62b7f447048ce/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(baseUrl)
    .build()

interface RobinHoodService {

    @GET("instruments.json")
    suspend fun getInstruments(): List<Instrument>
}

object RobinhoodApi {
    val retrofitService: RobinHoodService =
        retrofit.create(RobinHoodService::class.java)
}