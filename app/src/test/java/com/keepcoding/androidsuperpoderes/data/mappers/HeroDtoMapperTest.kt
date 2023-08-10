package com.keepcoding.androidsuperpoderes.data.mappers

import com.keepcoding.androidsuperpoderes.data.remote.dto.NasaDto
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class NasaDtoMapperTest {

    @Test
    fun `WHEN toNasaModel with values EXPECT model has value`() {
        val NasaDto = NasaDto(
            id = "test-id",
            photo = "photo-url",
            name = "Sample Name",
            description = "descripcion",
            favorite = false
        )
        val res = NasaDto.toNasaModel()

        assertThat(res.id, `is`("test-id"))
    }

    @Test
    fun `WHEN toNasaModel with null EXPECT empty string`() {
        val NasaDto = NasaDto(
            id = null,
            photo = null,
            name = null,
            description = null,
            favorite = false
        )
        val res = NasaDto.toNasaModel()

        assertThat(res.id, `is`(""))
    }
}