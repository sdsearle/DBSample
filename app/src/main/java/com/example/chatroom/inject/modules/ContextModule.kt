/**
 * Created by Spencer Searle on 2020-02-20.
 */

package com.example.chatroom.inject.modules

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ContextModule(val context: Context) {

    @Provides
    fun provideContext(): Context = context
}