package com.keepcoding.androidsuperpoderes.presentation.login

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import com.keepcoding.androidsuperpoderes.R
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Rule
import org.junit.Test


class LoginScreenTest {
    @get:Rule
    val rule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun testLoginSuccess() {
        var logged = false
        rule.setContent {
            LoginScreen(onLoginSuccess = {
                 logged = true
            }, onForgotClicked = {})
        }

        val loginText = rule.activity.getString(R.string.login)

        // Localizar las vistas de los Inputs y setear credenciales
        rule.onNodeWithTag(LOGIN_TEXT_FIELD_USER)
            .performTextInput("alextfos@keepcoding.io")

        rule.onNodeWithTag(LOGIN_TEXT_FIELD_PASSWORD)
            .performTextInput("password")

        rule.onNodeWithText(loginText).performClick()

        assertThat(logged, `is`(true))
    }

    @Test
    fun testLoginFail() {
        var logged = false
        rule.setContent {
            LoginScreen(onLoginSuccess = {
                logged = true
            }, onForgotClicked = {})
        }

        val loginText = rule.activity.getString(R.string.login)
        // Localizar las vistas de los Inputs y setear credenciales
        rule.onNodeWithTag(LOGIN_TEXT_FIELD_USER)
            .performTextInput("alextfos@keepcoding.io")

        rule.onNodeWithTag(LOGIN_TEXT_FIELD_PASSWORD)
            .performTextInput("password1")

        rule.onNodeWithText(loginText).performClick()

        assertThat(logged, `is`(false))
    }
}
