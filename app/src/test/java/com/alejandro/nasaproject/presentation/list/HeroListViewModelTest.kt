package com.alejandro.nasaproject.presentation.list

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.alejandro.nasaproject.NasaTestDataBuilder
import com.alejandro.nasaproject.domain.usecase.GetNasaListUseCase
import com.alejandro.nasaproject.testutil.DefaultDispatcherRule
import com.alejandro.nasaproject.testutil.getOrAwaitValue
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.*
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class NasaListViewModelTest {
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()
    @get:Rule
    val defaultDispatcherRule = DefaultDispatcherRule()

    @MockK(relaxed = true)
    private lateinit var getNasaListUseCase: GetNasaListUseCase

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    @After
    fun tearDown() {
        // Liberar recursos del test
    }

    @Test
    fun `WHEN viewModel init EXPECT data at LiveData`() = runTest {
        coEvery { getNasaListUseCase.invoke() } returns NasaTestDataBuilder()
            .withNumElements(15)
            .buildList()

        val viewModel = NasaListViewModel(getNasaListUseCase)

        val res = viewModel.nasaList.getOrAwaitValue()

        assertThat(res.size, `is`(15))

    }

}
