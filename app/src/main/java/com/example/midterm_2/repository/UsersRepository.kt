package com.example.midterm_2.repository

import androidx.lifecycle.LiveData
import com.example.midterm_2.api.ApiInterface
import androidx.lifecycle.MutableLiveData
import com.example.midterm_2.model.Users

class UsersRepository(private val apiInterface: ApiInterface) {
    private val usersLiveData = MutableLiveData<Users>()

    val users: LiveData<Users>
    get() = usersLiveData

    suspend fun getUsers(){
        val result = apiInterface.getUsers()
        if (result.body() != null){
            usersLiveData.postValue(result.body())
        }
    }
}