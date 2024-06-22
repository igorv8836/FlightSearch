package com.example.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.database.entities.OfferEntity

@Dao
interface OfferDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(offer: List<OfferEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(offer: OfferEntity)

    @Update
    suspend fun update(offer: OfferEntity)

    @Query("SELECT * FROM offer")
    suspend fun getAll(): List<OfferEntity>

    @Query("SELECT * FROM offer WHERE id = :id")
    suspend fun getById(id: Int): OfferEntity

    @Query("DELETE FROM offer")
    suspend fun deleteAll()

    @Query("DELETE FROM offer WHERE id = :id")
    suspend fun deleteById(id: Int)
}