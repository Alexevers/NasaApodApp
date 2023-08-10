package com.alejandro.nasaproject.domain.model

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test


internal class NasaModelTest{
    val nasaModel = NasaModel("1","date","description","photo")

    @Test
    fun `WHEN nasaModel id is 5 EXPECT id is 5`(){
        assertThat(nasaModel.id, `is`("1"))
    }
    @Test
    fun `WHEN nasaModel date is date EXPECT date is date`(){
        assertThat(nasaModel.date, `is`("date"))
    }@Test
    fun `WHEN nasaModel description is alex EXPECT description is alex`(){
        assertThat(nasaModel.id, `is`("1"))
    }@Test
    fun `WHEN nasaModel photo is foto EXPECT photo is foto`(){
        assertThat(nasaModel.photo, `is`("photo"))
    }


}