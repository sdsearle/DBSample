/**
 * Created by Spencer Searle on 2020-02-18.
 */

package com.example.chatroom.database

import androidx.lifecycle.MutableLiveData
import com.example.chatroom.models.Chat

class ChatRepo {
    protected val chats = mutableMapOf<Int, MutableLiveData<Chat>>()
}