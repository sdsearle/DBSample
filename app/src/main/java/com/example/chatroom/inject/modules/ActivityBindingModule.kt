/**
 * Created by Spencer Searle on 2020-02-18.
 */

package com.example.chatroom.inject.modules

import com.example.chatroom.activity.MainActivity
import com.example.chatroom.fragment.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun mainFragment(): MainFragment
}