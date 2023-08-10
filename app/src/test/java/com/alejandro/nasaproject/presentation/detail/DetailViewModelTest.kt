package com.alejandro.nasaproject.presentation.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.alejandro.nasaproject.NasaTestDataBuilder
import com.alejandro.nasaproject.domain.usecase.GetDetailUseCase
import com.alejandro.nasaproject.testutil.DefaultDispatcherRule
import com.alejandro.nasaproject.testutil.getOrAwaitValue
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class DetailViewModelTest {
    @get:Rule
    val instantExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()
    @get:Rule
    val defaultDispatcherRule: DefaultDispatcherRule = DefaultDispatcherRule()

    @MockK(relaxed = true)
    private lateinit var getDetailUseCase: GetDetailUseCase

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `WHEN detail viewModel getData EXPECT returns data`() = runTest {
        coEvery { getDetailUseCase.invoke("test-id") } returns
                NasaTestDataBuilder().buildSingle()

        val viewModel = DetailViewModel(getDetailUseCase)

        viewModel.getNasa("test-id")

        val res = viewModel.nasa.getOrAwaitValue()

        assertThat(res.id, `is`("test-id"))
    }

}