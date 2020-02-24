/**
 * Created by Chris Renfrow on 1/30/18.
 */

package com.example.chatroom.providers

import androidx.annotation.DimenRes

interface DimenProvider {

    fun getDimen(@DimenRes resID: Int): Float
}