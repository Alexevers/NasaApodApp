package com.alejandro.nasaproject.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.TextField
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alejandro.nasaproject.R

const val LOGIN_TEXT_FIELD_USER = "LOGIN_TEXT_FIELD_USER"
const val LOGIN_TEXT_FIELD_PASSWORD = "LOGIN_TEXT_FIELD_PASSWORD"

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit,
    // Prueba de paso de parámetros
    onForgotClicked: (Int) -> Unit
) {

    var email by remember {
        // mutableStateOf("")
        mutableStateOf("alextfos@alejandro.io")
    }

    var password by remember {
        mutableStateOf("password")
        //mutableStateOf("")
    }

    val firaNasaFamily = FontFamily(
        Font(R.font.nasa, FontWeight.Light)
    )

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.fondo_login2),
            contentDescription = "Fondo con una imagen de cielo estrellado",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent)
            ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.size(250.dp),
            painter = painterResource(id = R.drawable.nasa_logo),
            contentScale = ContentScale.Crop,
            contentDescription = "SuperNasa Application"
        )

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(10.dp)
        )

        TextField(
            modifier = Modifier

                //.border(1.dp, Color.Gray)
                .testTag(LOGIN_TEXT_FIELD_USER)
                .clip(RoundedCornerShape(10.dp))
                .background(color = Color(0xAEB6B7BE)),

            value = email,
            placeholder = {
                  Text("Email")
            },
            onValueChange = { newValue ->
                email = newValue
            },label = { Text("Email")},
            leadingIcon = {
                Image(
                    imageVector = Icons.Default.Email,
                    contentDescription = "icono de carta"
                )
            }
        )
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(10.dp)
        )
        TextField(
            modifier = Modifier
                .testTag(LOGIN_TEXT_FIELD_PASSWORD)
                .clip(RoundedCornerShape(10.dp))
                .background(color = Color(0xAEB6B7BE))
                ,
            value = password,
            placeholder = {
                  Text("Password")
            },
            onValueChange = {
                password = it
            },label = { Text("Password")},
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Lock,
                    contentDescription = "Imagen de candado"
                )
            },

        )

        Spacer(
            modifier = Modifier
                .size(20.dp)
        )

        Button(
            onClick = {
                if (authenticate(email, password)) {
                    onLoginSuccess()
                }
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xED1F25A5),
                contentColor = Color(0xFFFFFFFF)
            )

        ) {
            Icon(
                painter = painterResource(R.drawable.baseline_rocket_launch_24),

                contentDescription = "Icono de cohete",
                tint = Color(0xFFC41E2C)
            )
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Text(text = "Iniciar Sesión", fontFamily = firaNasaFamily
            )
        }
        Spacer(
            modifier = Modifier
                .size(20.dp)
        )



        /*
        onClick = {
        onLoginSuccess.invoke()
        onLoginSuccess()
        }
        */


    }
}

fun authenticate(user: String, password: String) =
    user == "alextfos@alejandro.io" && password == "password"


@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen(
        onLoginSuccess = {

        },
        onForgotClicked = { test ->

        }
    )
}
