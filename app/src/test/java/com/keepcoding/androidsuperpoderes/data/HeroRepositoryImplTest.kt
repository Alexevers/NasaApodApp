package com.keepcoding.androidsuperpoderes.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.keepcoding.androidsuperpoderes.data.local.LocalDataSource
import com.keepcoding.androidsuperpoderes.data.local.model.NasaLocal
import com.keepcoding.androidsuperpoderes.data.remote.RemoteDataSource
import com.keepcoding.androidsuperpoderes.data.remote.dto.NasaDto
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

class NasaRepositoryImplTest {
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
    fun `WHEN getNasaList EXPECT local data`() = runTest {
        coEvery { localDataSource.getNasaList() } returns getListLocal()
        coEvery { remoteDataSource.getNasaList() } returns listOf<NasaDto>()

        val repo = NasaRepositoryImpl(
            localDataSource = localDataSource,
            remoteDataSource = remoteDataSource
        )

        val res = repo.getNasaList()


        assertThat(res, instanceOf(List::class.java))
        assertThat(res.size, `is`(2))
    }

    @Test
    fun `WHEN getNasaList EXPECT remote data`() = runTest {
        coEvery { localDataSource.getNasaList() } returns listOf<NasaLocal>()
        coEvery { remoteDataSource.getNasaList() } returns getListRemote()

        val repo = NasaRepositoryImpl(
            localDataSource = localDataSource,
            remoteDataSource = remoteDataSource
        )

        val res = repo.getNasaList()

        assertThat(res, instanceOf(List::class.java))
        assertThat(res.size, `is`(2))
    }
}

fun getListLocal() = listOf(
        NasaLocal("id", "name", "https://photo-url", true),
        NasaLocal("id", "name", "https://photo-url", true)
    )

fun getListRemote() = listOf<NasaDto>(
    NasaDto("id", "name", "url", "https://photo-url", true),
    NasaDto("id", "name", "url", "https://photo-url", true)
)