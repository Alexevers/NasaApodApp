package com.keepcoding.androidsuperpoderes.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "SuperNasaTable")
data class NasaLocal(
    @PrimaryKey @ColumnInfo(name = "title") val id: String,
    @ColumnInfo(name = "date") val date: String,
    @ColumnInfo(name = "explanation") val description: String,
    @ColumnInfo(name = "url") val photo: String
)
