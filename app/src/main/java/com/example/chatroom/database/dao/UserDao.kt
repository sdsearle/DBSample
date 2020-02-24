/**
 * Created by Spencer Searle on 2020-02-19.
 */

package com.example.chatroom.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.chatroom.database.entity.UserEntity

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: UserEntity)

    @Update
    fun updateUser(user: UserEntity)

    @Delete
    fun deleteUser(user: UserEntity)

    @Query("SELECT * FROM userentity WHERE name == :name")
    fun getUserByName(name: String): LiveData<List<UserEntity>>

    @Query("SELECT * FROM userentity")
    fun getUsers(): LiveData<List<UserEntity>>

    @Query("SELECT * FROM userentity WHERE id == :id")
    fun getUserByID(id: Int): LiveData<List<UserEntity>>
}