package com.alejandro.nasaproject.data.mappers

//import androidx.compose.ui.tooling.data.EmptyGroup.name
import com.alejandro.nasaproject.data.local.model.NasaLocal
import com.alejandro.nasaproject.data.remote.dto.NasaDto
import com.alejandro.nasaproject.domain.model.NasaModel

fun NasaDto.toNasaModel() = NasaModel(
    id = id ?: "",
    photo = photo ?: "",
    date = date ?: "",
    description = description ?: ""
)

fun NasaDto.toNasaLocal() = NasaLocal(
    id = id ?: "",
    date = date ?: "",
    photo = photo ?: "",
    description = description ?: ""
)

fun NasaLocal.toNasaModel() = NasaModel(
    id = id,
    photo = photo,
    date = date,
    description = description
)

fun NasaDto.toNasaModelConstructorWithoutName() = NasaModel(
    id = id ?: "",
    date = date ?: "",
    photo = photo ?: "",
    description = description ?: ""
)
/*

Demo de acceso a datos desde una función de extensión
fun NasaDto.test() {
    this.name = "test"
}
*/