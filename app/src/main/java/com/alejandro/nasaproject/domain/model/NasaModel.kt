package com.alejandro.nasaproject.domain.model

/*Data class con los atributos que tendrá el modelo de datos en la aplicación
* se recogeran los datos desde la API a estos atributos
* */
data class NasaModel(
    val id: String,
    val date: String,
    val description: String,
    val photo: String
)

