/**
 * Created by Spencer Searle on 2020-02-18.
 */

package com.example.chatroom.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Chat(
    val id: Int,
    val message: String,
    val userID: Int
) : Parcelable