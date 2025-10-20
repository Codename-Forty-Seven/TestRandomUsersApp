package com.example.testapp.di.modules

import com.example.testapp.data.remote.api.RandomUserApi
import com.example.testapp.data.repository.UserRepositoryImpl
import com.example.testapp.domain.repository.UserRepository
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides @Singleton
    fun provideLoggingInterceptor(): Interceptor {
        // Logging in debug style; in production you might lower the level
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BASIC
        }
    }

    @Provides @Singleton
    fun provideOkHttp(logging: Interceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

    @Provides @Singleton
    fun provideMoshi(): Moshi = Moshi.Builder().build()

    @Provides @Singleton
    fun provideRetrofit(client: OkHttpClient, moshi: Moshi): Retrofit =
        Retrofit.Builder()
            .baseUrl(RandomUserApi.BASE_URL)
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

    @Provides @Singleton
    fun provideApi(retrofit: Retrofit): RandomUserApi =
        retrofit.create(RandomUserApi::class.java)

    @Provides @Singleton
    fun provideRepository(impl: UserRepositoryImpl): UserRepository = impl
}