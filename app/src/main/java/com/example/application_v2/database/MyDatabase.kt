package com.example.application_v2.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class],version = 1, exportSchema = false)
abstract class MyDatabase : RoomDatabase(){
    abstract val UserDatabaseDao: UserDatabaseDao

    companion object{

        @Volatile
        private var INSTANCE: MyDatabase? = null

        fun getInstance(context: Context): MyDatabase{
            synchronized(this){
                var instance =  INSTANCE

                if (instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MyDatabase::class.java,
                        "myDatabase")
                        .fallbackToDestructiveMigration()
                        .build()
                        INSTANCE = instance
                }

                return instance
            }
        }
    }


}