/**
 * Created by Spencer Searle on 2020-02-19.
 */

package com.example.chatroom.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "name") val name: String


)