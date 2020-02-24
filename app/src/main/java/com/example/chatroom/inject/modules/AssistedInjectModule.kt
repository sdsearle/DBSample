/**
 * Created by Spencer Searle on 2020-02-19.
 */

package com.example.chatroom.inject.modules

import com.squareup.inject.assisted.dagger2.AssistedModule
import dagger.Module

@AssistedModule
@Module(includes = [AssistedInject_AssistedInjectModule::class])
abstract class AssistedInjectModule