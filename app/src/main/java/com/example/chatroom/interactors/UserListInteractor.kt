/**
 * Created by Spencer Searle on 2020-02-19.
 */

package com.example.chatroom.interactors

import androidx.lifecycle.LiveData
import com.example.chatroom.database.UserRepo
import com.example.chatroom.extension.liveDataOf
import javax.inject.Inject

class UserListInteractor @Inject constructor(
    private val userRepo: UserRepo
) {

    val userInteractors: LiveData<List<UserInteractor>> = liveDataOf(userRepo.get()?.map {
        UserInteractor(it.id, userRepo)
    })

    fun load() {
    }

}