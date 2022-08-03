package com.kito.homework14

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

object RetrofitClient {

    private const val BASE_URL = "https://run.mocky.io/v3/"
    val retrofitBuilder by lazy {
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    fun getDeliveryService () =
        retrofitBuilder.create(DeliveryService::class.java)

}

interface DeliveryService {
    @GET("f4864c66-ee04-4e7f-88a2-2fbd912ca5ab")
    suspend fun getItems(): Response <BuildingModel>
}