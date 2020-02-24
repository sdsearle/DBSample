/**
 * Created by Spencer Searle on 2020-02-19.
 */

package com.example.chatroom.interactors

import androidx.lifecycle.LiveData
import com.example.chatroom.database.UserRepo
import com.example.chatroom.extension.map
import javax.inject.Inject

class UserListInteractor @Inject constructor(
    private val userRepo: UserRepo
) {

    val userInteractors: LiveData<List<UserInteractor>> = userRepo.get().map { myList ->
        myList?.map {
            UserInteractor(it.id, userRepo)
        } ?: listOf()
    }

    fun load() {
    }

}