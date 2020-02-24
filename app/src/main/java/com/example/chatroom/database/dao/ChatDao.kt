/**
 * Created by Spencer Searle on 2020-02-19.
 */

package com.example.chatroom.database.dao

import androidx.room.*
import com.example.chatroom.database.entity.ChatEntity

@Dao
interface ChatDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertChat(chat: ChatEntity)

    @Update
    fun updateChat(chat: ChatEntity)

    @Delete
    fun deleteChat(chat: ChatEntity)

    @Query("SELECT * FROM chatentity WHERE userID == :userId")
    fun getChatByName(userId: String): List<ChatEntity>

    @Query("SELECT * FROM chatentity")
    fun getChats(): List<ChatEntity>
}