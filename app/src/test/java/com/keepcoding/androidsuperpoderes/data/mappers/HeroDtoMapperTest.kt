package com.keepcoding.androidsuperpoderes.data.mappers

import com.keepcoding.androidsuperpoderes.data.remote.dto.HeroDto
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class HeroDtoMapperTest {

    @Test
    fun `WHEN toHeroModel with values EXPECT model has value`() {
        val heroDto = HeroDto(
            id = "test-id",
            photo = "photo-url",
            name = "Sample Name",
            description = "descripcion",
            favorite = false
        )
        val res = heroDto.toHeroModel()

        assertThat(res.id, `is`("test-id"))
    }

    @Test
    fun `WHEN toHeroModel with null EXPECT empty string`() {
        val heroDto = HeroDto(
            id = null,
            photo = null,
            name = null,
            description = null,
            favorite = false
        )
        val res = heroDto.toHeroModel()

        assertThat(res.id, `is`(""))
    }
}