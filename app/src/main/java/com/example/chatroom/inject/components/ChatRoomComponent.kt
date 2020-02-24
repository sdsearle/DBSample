/**
 * Created by Spencer Searle on 2020-02-18.
 */

package com.example.chatroom.inject.components

import android.app.Application
import com.example.chatroom.ChatRoomApp
import com.example.chatroom.database.UserRepo
import com.example.chatroom.inject.modules.*
import com.example.chatroom.providers.AndroidResourceProvider
import com.example.chatroom.providers.AndroidSystemProvider
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@Component(
    modules = [ActivityBindingModule::class,
        AndroidInjectionModule::class,
        AssistedInjectModule::class,
        ContextModule::class,
        ResourceModule::class,
        UserRepoModule::class]
)
interface ChatRoomComponent : AndroidInjector<ChatRoomApp> {

    fun inject(into: UserRepo)
    fun inject(resourceProvider: AndroidResourceProvider)
    fun inject(systemProvider: AndroidSystemProvider)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun userRepoModule(userRepoModule: UserRepoModule): Builder
        fun contextModule(contextModule: ContextModule): Builder
        fun resourceModule(resourceModule: ResourceModule): Builder
        fun build(): ChatRoomComponent
    }

}