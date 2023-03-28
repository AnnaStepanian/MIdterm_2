package com.example.midterm_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.midterm_2.api.ApiInterface
import com.example.midterm_2.api.ApiUtilities
import com.example.midterm_2.repository.UsersRepository
import com.example.midterm_2.viewmodel.UsersViewModel
import com.example.midterm_2.viewmodel.UsersViewModelFactory
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    private lateinit var usersViewModel: UsersViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val apiInterface = ApiUtilities.getInstance().create(ApiInterface::class.java)
        val usersRepository = UsersRepository(apiInterface)
        usersViewModel = ViewModelProvider(this, UsersViewModelFactory(usersRepository)).get(
            UsersViewModel::class.java
        )
        usersViewModel.users.observe(this) {
            Log.d("MainActivity", "onCreate: ${it.toString()}")
        }
    }
}