/**
 * Created by Spencer Searle on 2020-02-18.
 */

package com.example.chatroom

import com.example.chatroom.database.AppDatabase
import com.example.chatroom.database.UserRepo
import com.example.chatroom.inject.components.ChatRoomComponent
import com.example.chatroom.inject.components.DaggerChatRoomComponent
import com.example.chatroom.inject.modules.ContextModule
import com.example.chatroom.inject.modules.UserRepoModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.DaggerApplication
import javax.inject.Inject

class ChatRoomApp : BaseApplication(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    private lateinit var component: ChatRoomComponent

    override fun applicationInjector(): AndroidInjector<out DaggerApplication>? {

        val userRepo = UserRepo(AppDatabase.getAppDataBase(this)!!)

        component = DaggerChatRoomComponent.builder()
            .userRepoModule(UserRepoModule(userRepo))
            .contextModule(ContextModule(this))
            .application(this)
            .build()
        return component
    }


}