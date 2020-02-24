/**
 * Created by Spencer Searle on 2020-02-19.
 */

package com.example.chatroom.interactors

import com.example.chatroom.database.UserRepo

class UserInteractor(
    val userId: Int,
    val userRepo: UserRepo
) {

    val user = userRepo.get(userId)

}