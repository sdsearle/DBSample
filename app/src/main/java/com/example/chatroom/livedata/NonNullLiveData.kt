/**
 * Created by Chris Renfrow on 1/29/19.
 */

package com.example.chatroom.livedata

import androidx.lifecycle.LifecycleOwner
import com.example.chatroom.lifecycle.NonNullObserver

interface NonNullLiveData<T> {
    fun getValue(): T

    fun observe(owner: LifecycleOwner, observer: NonNullObserver<T>)
}