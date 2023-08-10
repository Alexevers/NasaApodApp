package com.keepcoding.androidsuperpoderes.components

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.*
import org.junit.Test


class RangeSelectorDelegateTest {

    val rangeSelectorDelegate = RangeSelectorDelegate(40, 80)

    @Test
    fun `WHEN moveBottom EXPECT bottom is currentTop -1`() {
        rangeSelectorDelegate.moveBottom(90)
        assertThat(rangeSelectorDelegate.currentBottom, `is`(79))
    }

    @Test
    fun `WHEN moveTop EXPECT bottom is currentTop -1`() {
        rangeSelectorDelegate.currentBottom = 50
        rangeSelectorDelegate.moveTop(45)
        assertThat(rangeSelectorDelegate.currentTop, `is`(51))
    }

    @Test
    fun `WHEN moveTop over max EXPECT top is maxValue`() {
        rangeSelectorDelegate.moveTop(90)
        assertThat(rangeSelectorDelegate.currentTop, `is`(80))
    }

    @Test
    fun `WHEN moveBottom below min EXPECT currentBottom is minValue`() {
        rangeSelectorDelegate.moveBottom(30)
        assertThat(rangeSelectorDelegate.currentBottom, `is`(40))
    }

    @Test
    fun `WHEN moveBottom EXPECT same value`() {
        rangeSelectorDelegate.moveBottom(50)
        assertThat(rangeSelectorDelegate.currentBottom, `is`(50))
    }

    @Test
    fun `WHEN moveTop EXPECT same value`() {
        rangeSelectorDelegate.moveBottom(50)
        assertThat(rangeSelectorDelegate.currentBottom, `is`(50))
    }
}
