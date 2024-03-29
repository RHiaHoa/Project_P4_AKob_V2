package com.example.application_v2.addGym

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.application_v2.database.gym.GymDatabaseDao
import com.example.application_v2.database.user.UserDatabaseDao

class AddGymViewModelFactory(
    private val dataSource: GymDatabaseDao,
    private val application: Application
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddGymViewModel::class.java)) {
            return AddGymViewModel(dataSource, application) as T
        } else {
            throw IllegalAccessException("unknow view model class")
        }
    }
}