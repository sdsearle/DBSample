/**
 * Created by Spencer Searle on 2020-02-19.
 */

package com.example.chatroom.inject.modules

import com.example.chatroom.database.UserRepo
import dagger.Module
import dagger.Provides

@Module
open class UserRepoModule(private val repo: UserRepo) {

    @Provides
    open fun provideUserRepo() = repo
}