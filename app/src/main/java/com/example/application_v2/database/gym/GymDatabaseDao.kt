package com.example.application_v2.database.gym

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface GymDatabaseDao {
    @Insert
    fun insert(user: Gym)

    @Query("SELECT * FROM  gym WHERE name_gym = :name_gym")
    fun getGym(name_gym:String) : Gym?

    @Query("SELECT * FROM gym")
    fun getAll(): LiveData<List<Gym>>
}