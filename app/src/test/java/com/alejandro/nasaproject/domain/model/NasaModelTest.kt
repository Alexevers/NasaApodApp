package com.alejandro.nasaproject.domain.model

import com.alejandro.nasaproject.NasaTestDataBuilder
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.MatcherAssert.*
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.junit.Test

class NasaModelTest {

    //
    var nasaModel = NasaModel(
        "56",
        "Alex",
        "https://foto",
        "descripcion"
    )

    @Test
    fun `WHEN create model EXPECT not null value`() {
        assertThat(nasaModel, instanceOf(NasaModel::class.java))
        assertThat(nasaModel, notNullValue())
    }

    @Test
    fun `WHEN NasaModel id is 56 EXPECT id = 56`() {
        val Nasa = NasaTestDataBuilder()
            .buildSingle()
        assertThat(Nasa.id, `is`("test-id"))
    }

    @Test
    fun `WHEN NasaModel name is Alex EXPECT name = Alex`() {
        val Nasa = NasaTestDataBuilder()
            .withName("Alex")
            .buildSingle()
        assertThat(Nasa.id, `is`("Alex"))
    }

    /**
     * Movido a StringExtTest
     */
    @Test
    fun `WHEN creates NasaModel EXPECT photoUrl contains schema`() {
        //assertThat(NasaModel.photoUrl, `is`("foto"))
        assertThat(nasaModel.photo, nasaModel.photo.startsWith("https"))
    }

}