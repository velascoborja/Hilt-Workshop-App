package com.gigigo.hiltapp.data.api.di

import com.gigigo.hiltapp.BuildConfig
import com.gigigo.hiltapp.data.api.services.MoviesService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideMoviesService(retrofit: Retrofit) = retrofit.create(MoviesService::class.java)

    @Provides
    @Singleton
    fun provideRetrofit(@BaseUrl url: String, okHttpClient: OkHttpClient) =
        Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(url)
            .build()

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder().apply {
            addInterceptor { chain ->
                val request = chain.request().newBuilder().also {
                    it.addHeader("Authorization", "Bearer ${BuildConfig.API_ACCESS_TOKEN}")
                }

                chain.proceed(request.build())
            }

            if (BuildConfig.DEBUG) addInterceptor(HttpLoggingInterceptor().also {
                it.setLevel(HttpLoggingInterceptor.Level.HEADERS)
            })
        }.build()

    @Provides
    @BaseUrl
    @Singleton
    fun provideBaseUrl() = BuildConfig.API_BASE_URL

}