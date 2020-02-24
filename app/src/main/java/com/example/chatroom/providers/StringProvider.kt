package com.example.chatroom.providers

import android.text.Spanned
import androidx.annotation.PluralsRes
import androidx.annotation.StringRes

/**
 * Created by Chris Renfrow on 12/13/17.
 */
interface StringProvider {

    fun getString(@StringRes resID: Int): String

    fun getString(@StringRes resId: Int, vararg formatArgs: Any): String

    fun getPluralString(@PluralsRes resID: Int, count: Int): String

    fun getPluralString(@PluralsRes resID: Int, count: Int, vararg formatArgs: Any): String
    fun getHtmlString(resID: Int): Spanned
    fun getHtmlString(resId: Int, vararg formatArgs: Any): Spanned
}