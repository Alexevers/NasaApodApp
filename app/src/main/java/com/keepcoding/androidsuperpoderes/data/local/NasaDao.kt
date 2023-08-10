package com.keepcoding.androidsuperpoderes.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.keepcoding.androidsuperpoderes.data.local.model.NasaLocal

// Create
// Read
// Update
// Delete

@Dao
interface NasaDao {

    @Query("SELECT * FROM SuperNasaTable")
    suspend fun getAll(): List<NasaLocal>

    // TODO
    //@Query("SELECT * FROM SuperNasaTable")
    //suspend fun getFavorites(): List<NasaLocal>

    //@Insert(onConflict = OnConflictStrategy.REPLACE)
    //suspend fun insertAll(vararg superNasa: NasaLocal)

    @Query("SELECT * FROM SuperNasaTable WHERE title=:id")
    suspend fun getNasaById(id: String) : NasaLocal

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<NasaLocal>)

    @Delete
    suspend fun delete(model: NasaLocal)
}
