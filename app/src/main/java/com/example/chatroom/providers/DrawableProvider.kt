package com.example.chatroom.providers

import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes

/**
 * Created by Chris Renfrow on 1/3/18.
 */
interface DrawableProvider {

    fun getDrawable(@DrawableRes resID: Int?): Drawable?

}