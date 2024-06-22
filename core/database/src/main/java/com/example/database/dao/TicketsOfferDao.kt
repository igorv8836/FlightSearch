package com.example.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.database.entities.TicketsOfferEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TicketsOfferDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(ticketsOfferEntity: List<TicketsOfferEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(ticketsOfferEntity: TicketsOfferEntity)

    @Update
    suspend fun update(ticketsOfferEntity: TicketsOfferEntity)

    @Query("SELECT * FROM tickets_offer")
    fun getAll(): Flow<List<TicketsOfferEntity>>

    @Query("SELECT * FROM tickets_offer WHERE id = :id")
    fun getById(id: Int): Flow<TicketsOfferEntity>

    @Query("DELETE FROM tickets_offer")
    suspend fun deleteAll()

    @Query("DELETE FROM tickets_offer WHERE id = :id")
    suspend fun deleteById(id: Int)
}