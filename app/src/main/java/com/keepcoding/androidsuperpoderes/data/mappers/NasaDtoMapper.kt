package com.keepcoding.androidsuperpoderes.data.mappers

//import androidx.compose.ui.tooling.data.EmptyGroup.name
import com.keepcoding.androidsuperpoderes.data.local.model.NasaLocal
import com.keepcoding.androidsuperpoderes.data.remote.dto.NasaDto
import com.keepcoding.androidsuperpoderes.domain.model.NasaModel

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