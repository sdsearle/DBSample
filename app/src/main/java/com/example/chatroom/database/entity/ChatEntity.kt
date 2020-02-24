/**
 * Created by Spencer Searle on 2020-02-18.
 */

package com.example.chatroom.database.entity

import androidx.room.*

@Entity(
    foreignKeys = [ForeignKey(
        entity = UserEntity::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("userID"),
        onDelete = ForeignKey.CASCADE
    )],
    indices = [Index("userID")]
)
data class ChatEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int,

    @ColumnInfo(name = "message") var message: String,

    @ColumnInfo(name = "userID") val userID: Int
)