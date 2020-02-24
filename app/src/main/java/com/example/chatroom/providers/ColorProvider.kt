package com.example.chatroom.providers

import androidx.annotation.ColorRes

/**
 * Created by Chris Renfrow on 1/3/18.
 */
interface ColorProvider {

    fun getColor(@ColorRes resID: Int): Int

    fun getColor(@ColorRes resID: Int, alpha: Float): Int

    fun getColor(
        @ColorRes lowColorResID: Int, @ColorRes
        highColorResID: Int, proportion: Float
    ): Int
}