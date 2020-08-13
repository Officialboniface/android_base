package com.agromall.remote

import com.agromall.remote.util.NetworkResponseAdapterFactory
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Provide "make" methods to create instances of [APIService]
 * and its related dependencies, such as OkHttpClient, Gson, etc.
 */
object APIServiceFactory {

    const val BASE_URL = "https://theagromall.com"

    /**
     * Safe method for providing API service instance between debug an release
     */
    fun makeRemoteService(isDebug: Boolean): APIService {
        val okHttpClient = makeOkHttpClient(
            makeLoggingInterceptor(isDebug)
        )
        return makeRemoteService(makeMoshi(), okHttpClient)
    }

    /**
     * Creates the APIService instance
     */
    private fun makeRemoteService(moshi: Moshi, okHttpClient: OkHttpClient): APIService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addCallAdapterFactory(NetworkResponseAdapterFactory())
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
        return retrofit.create(APIService::class.java)
    }

    /**
     * Defines the OkHttpClient instance
     */
    private fun makeOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .connectTimeout(300, TimeUnit.SECONDS)
            .readTimeout(300, TimeUnit.SECONDS)
            .build()
    }

    /**
     * Provides a Gson instance that can also handle error json type
     */
    private fun makeMoshi(): Moshi {
        return Moshi.Builder().build()
    }

    /**
     * Logging interceptor for debug builds
     */
    private fun makeLoggingInterceptor(isDebug: Boolean): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = if (isDebug)
            HttpLoggingInterceptor.Level.BODY
        else
            HttpLoggingInterceptor.Level.NONE
        return logging
    }
}