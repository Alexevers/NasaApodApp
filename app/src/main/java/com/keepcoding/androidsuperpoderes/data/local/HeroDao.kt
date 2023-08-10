package com.keepcoding.androidsuperpoderes.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.keepcoding.androidsuperpoderes.data.local.model.HeroLocal

// Create
// Read
// Update
// Delete

@Dao
interface HeroDao {

    @Query("SELECT * FROM SuperHeroTable")
    suspend fun getAll(): List<HeroLocal>

    // TODO
    //@Query("SELECT * FROM SuperHeroTable")
    //suspend fun getFavorites(): List<HeroLocal>

    //@Insert(onConflict = OnConflictStrategy.REPLACE)
    //suspend fun insertAll(vararg superHero: HeroLocal)

    @Query("SELECT * FROM SuperHeroTable WHERE title=:id")
    suspend fun getHeroById(id: String) : HeroLocal

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<HeroLocal>)

    @Delete
    suspend fun delete(model: HeroLocal)
}
