package com.keepcoding.androidsuperpoderes.data.mappers

//import androidx.compose.ui.tooling.data.EmptyGroup.name
import com.keepcoding.androidsuperpoderes.data.local.model.HeroLocal
import com.keepcoding.androidsuperpoderes.data.remote.dto.HeroDto
import com.keepcoding.androidsuperpoderes.domain.model.HeroModel

fun HeroDto.toHeroModel() = HeroModel(
    id = id ?: "",
    photo = photo ?: "",
    date = date ?: "",
    description = description ?: ""
)

fun HeroDto.toHeroLocal() = HeroLocal(
    id = id ?: "",
    date = date ?: "",
    photo = photo ?: "",
    description = description ?: ""
)

fun HeroLocal.toHeroModel() = HeroModel(
    id = id,
    photo = photo,
    date = date,
    description = "" // TODO
)

fun HeroDto.toHeroModelConstructorWithoutName() = HeroModel(
    id = id ?: "",
    date = date ?: "",
    photo = photo ?: "",
    description = description ?: ""
)
/*

Demo de acceso a datos desde una función de extensión
fun HeroDto.test() {
    this.name = "test"
}
*/