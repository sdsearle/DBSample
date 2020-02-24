/**
 * Created by Spencer Searle on 2020-02-19.
 */

package com.example.chatroom.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class User(
    val id: Int,
    val name: String
) : Parcelable