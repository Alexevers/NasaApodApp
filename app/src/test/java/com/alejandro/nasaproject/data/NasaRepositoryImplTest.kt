package com.alejandro.nasaproject.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.alejandro.nasaproject.data.local.LocalDataSource
import com.alejandro.nasaproject.data.local.model.NasaLocal
import com.alejandro.nasaproject.data.remote.RemoteDataSource
import com.alejandro.nasaproject.data.remote.dto.NasaDto
import com.alejandro.nasaproject.testutil.DefaultDispatcherRule
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Before
import org.junit.Rule
import org.junit.Test


internal class NasaRepositoryImplTest{
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
        coEvery { localDataSource.getNasaList() } returns getListLocal()
        coEvery { remoteDataSource.getNasaList() } returns listOf<NasaDto>()

        val repo = NasaRepositoryImpl(
            localDataSource = localDataSource,
            remoteDataSource = remoteDataSource
        )

        val res = repo.getNasaList()


        MatcherAssert.assertThat(res, CoreMatchers.instanceOf(List::class.java))
        MatcherAssert.assertThat(res.size, CoreMatchers.`is`(2))
    }
    @Test
    fun `WHEN getHeroList EXPECT local `() = runTest {
        coEvery { localDataSource.getNasaList() } returns listOf<NasaLocal>()
        coEvery { remoteDataSource.getNasaList() } returns getListRemote()

        val repo = NasaRepositoryImpl(
            localDataSource = localDataSource,
            remoteDataSource = remoteDataSource
        )

        val res = repo.getNasaList()


        MatcherAssert.assertThat(res, CoreMatchers.instanceOf(List::class.java))
        MatcherAssert.assertThat(res.size, CoreMatchers.`is`(2))
    }

}

fun getListLocal() = listOf(
    NasaLocal("id", "name", "description", "photo"),
    NasaLocal("id", "name", "description", "photo")
)
fun getListRemote() = listOf(
    NasaDto("id", "name", "description", "photo"),
    NasaDto("id", "name", "description", "photo")
)