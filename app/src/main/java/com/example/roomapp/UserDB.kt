package com.example.roomapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ModelEntyty::class], version = 1)

abstract class UserDB : RoomDatabase() {

    abstract fun getUserDao(): UserDao


    companion object {
        private var INSANCE: UserDB? = null

        fun getInstance(context: Context): UserDB {
            return INSANCE ?: Room.databaseBuilder(
                context.applicationContext,
                UserDB::class.java,
                "user_database"
            ).build().also {
                INSANCE = it
            }
        }
    }
}