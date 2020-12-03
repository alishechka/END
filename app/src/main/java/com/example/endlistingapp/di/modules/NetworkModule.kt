package com.example.endlistingapp.di.modules

import com.example.endlistingapp.common.BASE_URL
import com.example.endlistingapp.network.EndClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@InstallIn(ApplicationComponent::class)
@Module
class NetworkModule {
    companion object {
        @Provides
        fun provideNewsClient(retrofit: Retrofit): EndClient {
            return retrofit.create(EndClient::class.java)
        }

        @Provides
        fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build()
        }

        @Provides
        fun provideHttpClient(): OkHttpClient {
            return OkHttpClient.Builder()
                .build()
        }
    }
}