package com.keepcoding.androidsuperpoderes.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.keepcoding.androidsuperpoderes.data.local.model.NasaLocal

@Database(entities = [NasaLocal::class], version = 1, exportSchema = false)
//Database(entities = [SuperNasaLocal::class, AnotherLocal::class], version = 1)
abstract class NasaDatabase : RoomDatabase() {
    // List of Dao
    abstract fun superNasaDao(): NasaDao
}