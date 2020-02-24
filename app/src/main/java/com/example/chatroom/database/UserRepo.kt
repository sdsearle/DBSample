/**
 * Created by Spencer S earle on 2020-02-19.
 */

package com.example.chatroom.database

import com.example.chatroom.database.entity.UserEntity
import com.example.chatroom.extension.dependentLiveData
import com.example.chatroom.extension.liveDataOf
import javax.inject.Inject

class UserRepo @Inject constructor(val database: AppDatabase) {

    /*protected val users = mapOf<Int, UserEntity>(database.userDao().getUsers().map {
        it.map { entity -> entity.id }
    }, database.userDao().getUsers().map {
        it.map { entity -> entity }
    } )*/

    val list = liveDataOf(listOf(UserEntity(0, "myUser"), UserEntity(1, "User 2")))

    val observableUsers = dependentLiveData(database.userDao().getUsers()) {
        if (database.getDatabaseCreated().value == true) {
            database.userDao().getUsers().value
        } else {
            listOf()
        }
    }
    protected val users = database.userDao().getUsers()

    fun add(user: UserEntity) {
        if (observableUsers.value?.contains(user) == true) {
            update(user)
        } else {
            database.userDao().insertUser(user)
            //Send Save
        }
    }

    fun update(user: UserEntity) {
        observableUsers.value?.elementAt(user.id)
        //Send update
    }

    fun get() = observableUsers //database.userDao().getUsers() //list


    fun get(userID: Int) =
        observableUsers.value?.get(userID) //database.userDao().getUserByID(userID) //list.value?.get(userID) //

}