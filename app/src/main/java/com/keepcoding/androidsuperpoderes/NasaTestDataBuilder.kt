package com.keepcoding.androidsuperpoderes

import com.keepcoding.androidsuperpoderes.domain.model.NasaModel


class NasaTestDataBuilder {
    val id = "test-id"
    var name = ""
    var photoUrl = ""
    var description = ""
    var numElements: Int = 1

    fun withName(name: String): NasaTestDataBuilder {
        this.name = name
        return this
    }

    fun withPhotoUrl(photoUrl: String): NasaTestDataBuilder {
        this.photoUrl = photoUrl
        return this
    }

    fun withDescription(description: String): NasaTestDataBuilder {
        this.description = description
        return this
    }

    fun withNumElements(numElements: Int): NasaTestDataBuilder {
        this.numElements = numElements

        return this
    }

    fun buildList(): List<NasaModel> {
        val list = mutableListOf<NasaModel>()

        for(i in 0 until numElements) {
            list.add(
                NasaModel(
                id,
                date = name,
                photo = photoUrl,
                description = description
            )
            )
        }

        return list.toList()
    }

    fun buildSingle() = NasaModel(
        id = id,
        date = name,
        photo = photoUrl,
        description = description
    )
}

