package com.keepcoding.androidsuperpoderes.presentation.common

import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.hasClickAction
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.printToLog
import com.keepcoding.androidsuperpoderes.NasaTestDataBuilder
import com.keepcoding.androidsuperpoderes.presentation.detail.NasaDetail
import org.junit.Rule
import org.junit.Test

class ShowNasaTest {
    @get:Rule
    val rule = createComposeRule()

    @Test
    fun testShowNasa() {
        rule.setContent {
            NasaDetail(
                NasaTestDataBuilder()
                    .withName("Sample")
                    .buildSingle()
            )
        }

        rule.onRoot().printToLog("MY TAG")

        rule.onNode(
            hasText("Sample") and
                    hasClickAction()
        ).assertHasClickAction()

    }
}