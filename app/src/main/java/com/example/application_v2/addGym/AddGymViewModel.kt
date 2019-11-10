package com.example.application_v2.addGym

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.application_v2.database.gym.Gym
import com.example.application_v2.database.gym.GymDatabaseDao
import kotlinx.coroutines.*

class AddGymViewModel(val database: GymDatabaseDao, application: Application) :
    AndroidViewModel(application) {

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    var inputnameGym = MutableLiveData<String>()
    var inputaddress = MutableLiveData<String>()
    var inputtime = MutableLiveData<String>()
    var inputtype = MutableLiveData<String>()

    private var _gotoHome = MutableLiveData<Boolean>()
    val gotoHome: LiveData<Boolean>
        get() = _gotoHome

    private var _showSnackbarEvent = MutableLiveData<Boolean>()
    val showSnackBarEvent: LiveData<Boolean>
        get() = _showSnackbarEvent

    init {
        Log.i("AddGymViewModel", "ViewModelCreate")
    }

    fun clickButton() {
        uiScope.launch {
            Log.i("AddGymViewModel","Name Gym :"+inputnameGym.value)
            Log.i("AddGymViewModel","Address :"+inputaddress.value)
            Log.i("AddGymViewModel","Time :"+inputtime.value)
            Log.i("AddGymViewModel","Type :"+inputtype.value)
            if (checkMatchNotNull()){
                Log.i("AddGymViewModel","get gym all "+showGymAll())
                _showSnackbarEvent.value = true
            }else{
                var newGym = Gym(name_gym = inputnameGym.value ,
                    address = inputaddress.value ,
                    time =  inputtime.value ,
                    type = inputtype.value)
                insert(newGym)
                Log.i("AddGymViewModel","get gym all "+showGymAll().toString())
                _gotoHome.value = true
            }
        }
    }

    private suspend fun showGymAll(): LiveData<List<Gym>> {
        return withContext(Dispatchers.IO){
            database.getAll()
        }
    }

    private suspend fun insert(gym: Gym){
        withContext(Dispatchers.IO){
            database.insert(gym)
        }
    }

    private fun checkMatchNotNull() = (inputaddress.value == null
            || inputnameGym.value == null
            || inputtime.value == null
            || inputtype.value == null)

    override fun onCleared() {
        Log.i("RegisterViewModel", "ViewModelDestroy")
        super.onCleared()
        viewModelJob.cancel()
    }
}