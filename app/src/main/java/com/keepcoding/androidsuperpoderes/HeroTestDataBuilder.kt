package com.keepcoding.androidsuperpoderes

import com.keepcoding.androidsuperpoderes.domain.model.HeroModel


class HeroTestDataBuilder {
    val id = "test-id"
    var name = ""
    var photoUrl = ""
    var description = ""
    var numElements: Int = 1

    fun withName(name: String): HeroTestDataBuilder {
        this.name = name
        return this
    }

    fun withPhotoUrl(photoUrl: String): HeroTestDataBuilder {
        this.photoUrl = photoUrl
        return this
    }

    fun withDescription(description: String): HeroTestDataBuilder {
        this.description = description
        return this
    }

    fun withNumElements(numElements: Int): HeroTestDataBuilder {
        this.numElements = numElements

        return this
    }

    fun buildList(): List<HeroModel> {
        val list = mutableListOf<HeroModel>()

        for(i in 0 until numElements) {
            list.add(
                HeroModel(
                id,
                date = name,
                photo = photoUrl,
                description = description
            )
            )
        }

        return list.toList()
    }

    fun buildSingle() = HeroModel(
        id = id,
        date = name,
        photo = photoUrl,
        description = description
    )
}

