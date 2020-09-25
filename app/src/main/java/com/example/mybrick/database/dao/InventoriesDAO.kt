package com.example.mybrick.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.mybrick.database.entity.Inventory

@Dao
interface InventoriesDAO {
    @Query("SELECT * FROM Inventories")
    fun getAll(): List<Inventory>

    @Query("SELECT EXISTS(SELECT * FROM Inventories WHERE Id = :id)")
    fun checkIfExistsById(id: String): Boolean

    @Query("SELECT EXISTS(SELECT * FROM Inventories WHERE Name = :name)")
    fun checkIfExistsByName(name: String): Boolean

    @Query("SELECT Id FROM Inventories WHERE Name = :name LIMIT 1")
    fun findIdByName(name: String): Int?

    @Insert
    fun insert(newInventory: Inventory)

    @Delete
    fun delete(inventories: List<Inventory>)

    @Query("SELECT * FROM Inventories")
    fun findAll(): List<Inventory>

    fun deleteAll() {
        delete(findAll())
    }
}