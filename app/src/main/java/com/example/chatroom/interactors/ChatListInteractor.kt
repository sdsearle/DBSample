/**
 * Created by Spencer Searle on 2020-02-18.
 */

package com.example.chatroom.interactors

import com.example.chatroom.database.ChatRepo
import javax.inject.Inject

class ChatListInteractor @Inject constructor(
    val chatRepo: ChatRepo
)