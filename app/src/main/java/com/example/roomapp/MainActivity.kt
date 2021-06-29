package com.example.roomapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    lateinit var title: TextView
    lateinit var addUser: Button
    val userDB: UserDB? = null
    val user = ModelEntyty(0, "john", "poxos")

    lateinit var removeUser: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = findViewById(R.id.textView)
        addUser = findViewById(R.id.addUser)
        removeUser = findViewById(R.id.removeUser)


        addUser.setOnClickListener {


            GlobalScope.launch(Dispatchers.IO) { addUserMethod() }

        }
        removeUser.setOnClickListener {
            removeUserMethod()
        }
    }

    private fun removeUserMethod() {

        userDB.let {
            val db = UserDB.getInstance(this).getUserDao().deleteUser(user)
        }

    }

    private fun addUserMethod() {

        user.let {
            val dp = UserDB.getInstance(this).getUserDao().getSingleUser(it)
        }
    }


}