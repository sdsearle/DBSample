/**
 * Created by Spencer Searle on 2020-02-20.
 */

package com.example.chatroom.inject.modules

import android.content.Context
import com.example.chatroom.database.AppDatabase
import com.example.chatroom.providers.*
import dagger.Module
import dagger.Provides

@Module(includes = [ContextModule::class])
class ResourceModule {

    @Provides
    fun provideColorProvider(context: Context): ColorProvider = AndroidResourceProvider(context)

    @Provides
    fun provideDrawableProvider(context: Context): DrawableProvider =
        AndroidResourceProvider(context)

    @Provides
    fun provideDimenProvider(context: Context): DimenProvider = AndroidResourceProvider(context)

    @Provides
    fun provideIntegerProvider(context: Context): IntegerProvider = AndroidResourceProvider(context)

    @Provides
    fun provideLayoutManagerProvider(context: Context): LayoutManagerProvider =
        AndroidResourceProvider(context)

    @Provides
    fun provideStringProvider(context: Context): StringProvider = AndroidResourceProvider(context)

    @Provides
    fun provideDateProvider(context: Context): DateFormatProvider = AndroidSystemProvider(context)

    @Provides
    fun provideAppDatabase(context: Context): AppDatabase = AppDatabase.getAppDataBase(context)!!
}