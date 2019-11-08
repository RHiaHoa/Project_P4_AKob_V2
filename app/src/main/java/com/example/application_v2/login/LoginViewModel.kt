package com.example.application_v2.login

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.application_v2.database.UserDatabaseDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class LoginViewModel(val database: UserDatabaseDao, application: Application) :
    AndroidViewModel(application) {

    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    var inputusername = MutableLiveData<String>()
    var inputPassword = MutableLiveData<String>()

    private var _gotoHome = MutableLiveData<Boolean>()
    val gotoHome: LiveData<Boolean>
        get() = _gotoHome

    var _showToast = MutableLiveData<Boolean>()
    val showToast: LiveData<Boolean>
        get() = _showToast

    init {
        Log.i("LoginViewModel", "ViewModelCreate")
        _showToast.value = false
    }

    fun clickButton() {
        Log.i("LoginViewModel","username "+inputusername.value)
        Log.i("LoginViewModel","password "+inputPassword.value)
        if(checkMatchNotNull()){
            _showToast.value = true
        }
        else{
            _gotoHome.value = true
        }
    }

    private fun checkMatchNotNull() = (inputusername.value == null
            || inputPassword.value == null)

    override fun onCleared() {
        Log.i("LoginViewModel", "ViewModelDestroy")
        super.onCleared()
        viewModelJob.cancel()
    }


}
