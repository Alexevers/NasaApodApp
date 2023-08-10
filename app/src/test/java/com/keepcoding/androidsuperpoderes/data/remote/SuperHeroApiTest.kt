package com.keepcoding.androidsuperpoderes.data.remote

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.keepcoding.androidsuperpoderes.data.remote.dto.IdDto
import com.keepcoding.androidsuperpoderes.data.remote.dto.LocationDto
import com.keepcoding.androidsuperpoderes.data.remote.dto.SearchDto
import com.keepcoding.androidsuperpoderes.di.baseUrl
import com.keepcoding.androidsuperpoderes.testutil.DefaultDispatcherRule
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Assert.assertThrows
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Rule
import org.junit.Test
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@ExperimentalCoroutinesApi
class SuperHeroApiTest {
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val mainDispatcherRule = DefaultDispatcherRule()


    private lateinit var api: SuperHeroApi

    @Before
    fun setup() {
        api = retrofit.create(SuperHeroApi::class.java)
    }

    @Test
    fun `WHEN request hero list EXPECT result`() = runTest {
        val result = api.getHeroList(SearchDto())

        assertThat(result.isNotEmpty(), `is`(true))
    }

    @Test
    fun `WHEN request whit search EXPECT item`() = runTest {
        val result = api.getHeroList(SearchDto("Goku"))

        assertThat(result.size, `is`(1))
    }

    @Test
    fun `WHEN request whit random text EXPECT empty list`() = runTest {
        val result = api.getHeroList(SearchDto("asdf asdf"))

        assertThat(result.isEmpty(), `is`(true))
    }

    @Test
    fun `WHEN request hero location list EXPECT location list`() = runTest {
        val result = api.getHeroLocationList(
            IdDto(
                "14BB8E98-6586-4EA7-B4D7-35D6A63F5AA3"
            )
        )

        assertThat(result.isNotEmpty(), `is`(true))
    }

    @Test
    fun `WHEN request hero location list EXPECT empty list`() = runTest {
        val result = api.getHeroLocationList(
            IdDto(
                "81D51BD2-E82C-4E1D-8216-BDFB107C1F28"
            )
        )

        assertThat(result, instanceOf(List::class.java))
    }

    @Test(expected = HttpException::class)
    fun `WHEN request unkown location EXPECT throws exception`() = runTest {
        api.getHeroLocationList(
            IdDto(
                "81D51BD2-E82asdfaC-4E1D-8216-BDFB107C1F28"
            )
        )

        assert(false)
    }


    companion object {
        private lateinit var retrofit: Retrofit

        @BeforeClass
        @JvmStatic
        fun setupCommon() {
            retrofit = Retrofit.Builder()
                // lo ideal es probar contra un entorno estable
                // entorno de QA
                .baseUrl(baseUrl)
                .client(
                    OkHttpClient.Builder()
                        .addInterceptor(
                            HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT)
                                .apply {
                                    level = HttpLoggingInterceptor.Level.BODY
                                }).build()
                )
                .addConverterFactory(
                    MoshiConverterFactory.create(
                        Moshi.Builder()
                            .addLast(KotlinJsonAdapterFactory())
                            .build()
                    )
                ).build()
        }
    }
}

/*
Static context en Java
class Test {

    public static void doSomething() {

    }
}

Test.doSomething()
Test().doSomething()

 */