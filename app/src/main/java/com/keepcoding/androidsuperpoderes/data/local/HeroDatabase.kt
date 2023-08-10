package com.keepcoding.androidsuperpoderes.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.keepcoding.androidsuperpoderes.data.local.model.HeroLocal

@Database(entities = [HeroLocal::class], version = 1, exportSchema = false)
//Database(entities = [SuperHeroLocal::class, AnotherLocal::class], version = 1)
abstract class HeroDatabase : RoomDatabase() {
    // List of Dao
    abstract fun superHeroDao(): HeroDao
}