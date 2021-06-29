package com.example.roomapp

import androidx.room.*


@Dao
interface UserDao {
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun getSingleUser(modelEntyty: ModelEntyty)

    @Query("SELECT * FROM ModelEntyty ORDER BY name ASC")
    fun getAllUser(): List<ModelEntyty>

    @Query("SELECT * FROM ModelEntyty WHERE surname LIKE:surname")
    fun getUserBySuraname(surname: String): List<ModelEntyty>

    @Delete
    fun deleteUser(modelEntyty: ModelEntyty)

}