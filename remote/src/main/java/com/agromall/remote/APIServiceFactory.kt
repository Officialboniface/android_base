package com.agromall.remote

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Provide "make" methods to create instances of [APIService]
 * and its related dependencies, such as OkHttpClient, Gson, etc.
 */
object APIServiceFactory {

    const val BASE_URL = ""

    /**
     * Safe method for providing API service instance between debug an release
     */
    fun makeRemoteService(isDebug: Boolean): APIService {
        val okHttpClient = makeOkHttpClient(
            makeLoggingInterceptor(isDebug)
        )
        return makeRemoteService(okHttpClient, makeGson())
    }

    /**
     * Creates the APIService instance
     */
    private fun makeRemoteService(okHttpClient: OkHttpClient, gson: Gson): APIService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
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
    private fun makeGson(): Gson {
        return GsonBuilder()
            .setLenient()
            .create()
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