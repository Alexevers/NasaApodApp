package com.keepcoding.androidsuperpoderes.di

import android.content.Context
import androidx.room.Room
import com.keepcoding.androidsuperpoderes.data.NasaRepository
import com.keepcoding.androidsuperpoderes.data.NasaRepositoryImpl
import com.keepcoding.androidsuperpoderes.data.local.NasaDao
import com.keepcoding.androidsuperpoderes.data.local.NasaDatabase
import com.keepcoding.androidsuperpoderes.data.local.LocalDataSource
import com.keepcoding.androidsuperpoderes.data.local.LocalDataSourceImpl
import com.keepcoding.androidsuperpoderes.data.remote.RemoteDataSource
import com.keepcoding.androidsuperpoderes.data.remote.RemoteDataSourceImpl
import com.keepcoding.androidsuperpoderes.data.remote.SuperNasaApi
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

    single<NasaRepository> { NasaRepositoryImpl(get(), get()) }

    single<RemoteDataSource> { RemoteDataSourceImpl(get()) }

    single<LocalDataSource> { LocalDataSourceImpl(get()) }

    single<SuperNasaApi> {
        getSuperNasaApi(get())
    }

    single {
        getDatabase(get())
    }

    single {
        providesNasaDao(get())
    }

}

private fun getSuperNasaApi(retrofit: Retrofit) =
    retrofit.create(SuperNasaApi::class.java)

private fun getDatabase(context: Context) : NasaDatabase =
    Room.databaseBuilder(
        context,
        NasaDatabase::class.java, "superNasa-db"
    ).build()

private fun providesNasaDao(db: NasaDatabase) : NasaDao =
    db.superNasaDao()
