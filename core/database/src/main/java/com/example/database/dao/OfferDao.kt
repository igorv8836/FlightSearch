package com.example.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.database.entities.OfferEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface OfferDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(offer: List<OfferEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(offer: OfferEntity)

    @Update
    suspend fun update(offer: OfferEntity)

    @Query("SELECT * FROM offer")
    fun getAll(): Flow<List<OfferEntity>>

    @Query("SELECT * FROM offer WHERE id = :id")
    fun getById(id: Int): Flow<OfferEntity>

    @Query("DELETE FROM offer")
    suspend fun deleteAll()

    @Query("DELETE FROM offer WHERE id = :id")
    suspend fun deleteById(id: Int)
}