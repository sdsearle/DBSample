/**
 * Created by Spencer Searle on 2020-02-19.
 */

package com.example.chatroom.database

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.chatroom.database.dao.ChatDao
import com.example.chatroom.database.dao.UserDao
import com.example.chatroom.database.entity.ChatEntity
import com.example.chatroom.database.entity.UserEntity


@Database(entities = [UserEntity::class, ChatEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun chatDao(): ChatDao

    companion object {
        var INSTANCE: AppDatabase? = null

        private var mIsDatabaseCreated = MutableLiveData<Boolean>()


        fun getAppDataBase(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "myDB"
                    ).build()
                }
            }
            INSTANCE?.setDatabaseCreated()
            return INSTANCE
        }

        fun destroyDataBase() {

            INSTANCE = null
        }
    }

    private fun setDatabaseCreated() {
        mIsDatabaseCreated.postValue(true)
    }

    fun getDatabaseCreated(): LiveData<Boolean> {
        return mIsDatabaseCreated
    }

}
