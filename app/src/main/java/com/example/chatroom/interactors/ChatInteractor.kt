/**
 * Created by Spencer Searle on 2020-02-18.
 */

package com.example.chatroom.interactors

import com.example.chatroom.database.UserRepo

class ChatInteractor(
    protected val userRepo: UserRepo,
    protected val userID: Int
) {
    val user = userRepo.get(userID)
}