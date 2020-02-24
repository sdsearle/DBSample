/**
 * Created by Chris Renfrow on 1/29/19.
 */

package com.example.chatroom.lifecycle

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import com.example.chatroom.livedata.NonNullLiveData

class NonNullMutableLiveData<T>(private val initialValue: T) : MutableLiveData<T>(),
    NonNullLiveData<T> {

    override fun getValue(): T {
        return super.getValue() ?: initialValue
    }

    fun notifyContentChanged() {
        postValue(value)
    }

    override fun observe(owner: LifecycleOwner, observer: NonNullObserver<T>) {
        super.observe(owner, observer.getObserver())
    }

}