package com.example.midterm_2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.midterm_2.model.Users
import com.example.midterm_2.repository.UsersRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UsersViewModel(private val usersRepository: UsersRepository): ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO) {
            usersRepository.getUsers()
        }
    }

    val users: LiveData<Users>
        get() = usersRepository.users
}