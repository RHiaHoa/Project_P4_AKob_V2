package com.example.application_v2.register

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.application_v2.database.UserDatabaseDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class RegisterViewModel( val database: UserDatabaseDao, application: Application) : AndroidViewModel(application){

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    var inputusername = MutableLiveData<String>()
    var inputPassword = MutableLiveData<String>()
    var inputConfirmPassword = MutableLiveData<String>()
    var inputEmail = MutableLiveData<String>()

    private var _gotoLogin = MutableLiveData<Boolean>()
    val gotoLogin: LiveData<Boolean>
        get() = _gotoLogin

    init {
        Log.i("RegisterViewModel","ViewModelCreate")
    }

    fun clickButton(){
//        Log.i("RegisterViewModel","username"+inputusername.value)
//        Log.i("RegisterViewModel","password"+inputPassword.value)
//        Log.i("RegisterViewModel","comfirmpassword "+inputConfirmPassword.value)
//        Log.i("RegisterViewModel","email "+inputEmail.value)
        if(checkMatchNotNull()) {}
        else if(!checkMatchPassword()) {}
        else {
            _gotoLogin.value = true
        }
    }

    private fun checkMatchNotNull() = (inputusername.value == null
            || inputPassword.value == null
            || inputConfirmPassword == null
            || inputEmail.value == null )

    private fun checkMatchPassword() = inputPassword.value == inputConfirmPassword.value

    override fun onCleared() {
        Log.i("RegisterViewModel","ViewModelDestroy")
        super.onCleared()
        viewModelJob.cancel()


    }
}