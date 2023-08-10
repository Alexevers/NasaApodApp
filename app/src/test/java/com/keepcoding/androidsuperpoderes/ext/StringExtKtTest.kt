package com.keepcoding.androidsuperpoderes.ext

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class StringExtKtTest {
    @Test
    fun `WHEN creates heroModel EXPECT photoUrl contains schema`() {
        val testStr = "https://some-domain.com"
        val res = testStr.hasHttps()
        assertThat(res, `is`(true))
    }
}