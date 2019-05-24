package com.soongon.marvelgallery.data.network.provider

import com.soongon.marvelgallery.BuildConfig
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor

fun makeHeadersInterceptor() = Interceptor { chain ->
    chain.proceed(chain.request().newBuilder()
        .addHeader("Accept", "application/json")
        .addHeader("Accept-Language", "en")
        .addHeader("Content-Type", "application/json")
        .build())
}

fun makeLoggingInterceptor() = HttpLoggingInterceptor().apply {
    level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
    else HttpLoggingInterceptor.Level.NONE
}

fun makeAddSecurityQueryInterceptor() = Interceptor { chain ->
    val originalRequest = chain.request()
    val timeStamp = System.currentTimeMillis()

    // Url customization: add query parameters
    val url = originalRequest.url().newBuilder()
        .addQueryParameter("apikey", BuildConfig.PUBLIC_KEY)
        .addQueryParameter("ts", "$timeStamp")
        .addQueryParameter("hash",
            calculatedMd5(timeStamp.toString() + BuildConfig.PRIVATE_KEY + BuildConfig.PUBLIC_KEY)
        )
        .build()

    // Request customization: set custom url
    val request = originalRequest
        .newBuilder()
        .url(url)
        .build()

    chain.proceed(request)
}