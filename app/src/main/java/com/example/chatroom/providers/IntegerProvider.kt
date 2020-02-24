/**
 * Created by Chris Renfrow on 1/30/18.
 */

package com.example.chatroom.providers

import androidx.annotation.IntegerRes

interface IntegerProvider {

    fun getInt(@IntegerRes resID: Int): Int
}