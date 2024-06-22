package com.example.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.database.entities.TicketEntity

@Dao
interface TicketDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(ticketEntity: List<TicketEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(ticketEntity: TicketEntity)

    @Update
    suspend fun update(ticketEntity: TicketEntity)

    @Query("SELECT * FROM ticket")
    suspend fun getAll(): List<TicketEntity>

    @Query("SELECT * FROM ticket WHERE id = :id")
    suspend fun getById(id: Int): TicketEntity

    @Query("DELETE FROM ticket")
    suspend fun deleteAll()

    @Query("DELETE FROM ticket WHERE id = :id")
    suspend fun deleteById(id: Int)
}