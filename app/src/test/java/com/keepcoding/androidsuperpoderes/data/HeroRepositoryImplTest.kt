package com.keepcoding.androidsuperpoderes.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.keepcoding.androidsuperpoderes.data.local.LocalDataSource
import com.keepcoding.androidsuperpoderes.data.local.model.HeroLocal
import com.keepcoding.androidsuperpoderes.data.remote.RemoteDataSource
import com.keepcoding.androidsuperpoderes.data.remote.dto.HeroDto
import com.keepcoding.androidsuperpoderes.testutil.DefaultDispatcherRule
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HeroRepositoryImplTest {
    @get:Rule
    val instantExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()
    @get:Rule
    val defaultDispatcherRule: DefaultDispatcherRule = DefaultDispatcherRule()

    @MockK(relaxed = true)
    private lateinit var localDataSource: LocalDataSource

    @MockK(relaxed = true)
    private lateinit var remoteDataSource: RemoteDataSource


    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `WHEN getHeroList EXPECT local data`() = runTest {
        coEvery { localDataSource.getHeroList() } returns getListLocal()
        coEvery { remoteDataSource.getHeroList() } returns listOf<HeroDto>()

        val repo = HeroRepositoryImpl(
            localDataSource = localDataSource,
            remoteDataSource = remoteDataSource
        )

        val res = repo.getHeroList()


        assertThat(res, instanceOf(List::class.java))
        assertThat(res.size, `is`(2))
    }

    @Test
    fun `WHEN getHeroList EXPECT remote data`() = runTest {
        coEvery { localDataSource.getHeroList() } returns listOf<HeroLocal>()
        coEvery { remoteDataSource.getHeroList() } returns getListRemote()

        val repo = HeroRepositoryImpl(
            localDataSource = localDataSource,
            remoteDataSource = remoteDataSource
        )

        val res = repo.getHeroList()

        assertThat(res, instanceOf(List::class.java))
        assertThat(res.size, `is`(2))
    }
}

fun getListLocal() = listOf(
        HeroLocal("id", "name", "https://photo-url", true),
        HeroLocal("id", "name", "https://photo-url", true)
    )

fun getListRemote() = listOf<HeroDto>(
    HeroDto("id", "name", "url", "https://photo-url", true),
    HeroDto("id", "name", "url", "https://photo-url", true)
)