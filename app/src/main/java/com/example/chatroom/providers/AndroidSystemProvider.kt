/**
 * Created by Chris Renfrow on 4/8/18.
 */

package com.example.chatroom.providers

import android.content.Context
import android.text.format.DateFormat
import javax.inject.Inject

class AndroidSystemProvider @Inject constructor(val context: Context) : DateFormatProvider {

    override fun is24Hour() = DateFormat.is24HourFormat(context)
}