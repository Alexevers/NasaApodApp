package com.keepcoding.androidsuperpoderes.di

import android.content.Context
import androidx.room.Room
import com.keepcoding.androidsuperpoderes.data.HeroRepository
import com.keepcoding.androidsuperpoderes.data.HeroRepositoryImpl
import com.keepcoding.androidsuperpoderes.data.local.HeroDao
import com.keepcoding.androidsuperpoderes.data.local.HeroDatabase
import com.keepcoding.androidsuperpoderes.data.local.LocalDataSource
import com.keepcoding.androidsuperpoderes.data.local.LocalDataSourceImpl
import com.keepcoding.androidsuperpoderes.data.remote.RemoteDataSource
import com.keepcoding.androidsuperpoderes.data.remote.RemoteDataSourceImpl
import com.keepcoding.androidsuperpoderes.data.remote.SuperHeroApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
//import com.keepcoding.androidsuperpoderes.BuildConfig

val baseUrl = "https://api.nasa.gov/planetary/"
//val baseUrl = "https://dragonball.keepcoding.education/"
val dataModule = module {

    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT).apply {
                level = HttpLoggingInterceptor.Level.BODY
            }).build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(get())
            .addConverterFactory(MoshiConverterFactory.create(get()))
            .build()
    }

    single<Moshi> {
        Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
    }

    single<HeroRepository> { HeroRepositoryImpl(get(), get()) }

    single<RemoteDataSource> { RemoteDataSourceImpl(get()) }

    single<LocalDataSource> { LocalDataSourceImpl(get()) }

    single<SuperHeroApi> {
        getSuperHeroApi(get())
    }

    single {
        getDatabase(get())
    }

    single {
        providesHeroDao(get())
    }

}

private fun getSuperHeroApi(retrofit: Retrofit) =
    retrofit.create(SuperHeroApi::class.java)

private fun getDatabase(context: Context) : HeroDatabase =
    Room.databaseBuilder(
        context,
        HeroDatabase::class.java, "superhero-db"
    ).build()

private fun providesHeroDao(db: HeroDatabase) : HeroDao =
    db.superHeroDao()
