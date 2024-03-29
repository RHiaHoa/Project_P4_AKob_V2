package com.example.application_v2.database.gym

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "gym")
class Gym(
    @PrimaryKey(autoGenerate = true)
    var gymId: Int =0 ,

    @ColumnInfo(name = "name_gym")
    var name_gym : String?,

    @ColumnInfo(name = "address")
    var address : String?,

    @ColumnInfo(name = "time")
    var time : String?,

    @ColumnInfo(name = "type")
    var type : String?
)


