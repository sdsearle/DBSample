/**
 * Created by Chris Renfrow on 7/6/18.
 */

package com.example.chatroom.extension

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

inline fun <reified T : ViewModel> Fragment.getViewModel(): T {
    return ViewModelProviders.of(this).get(T::class.java)
}

inline fun <reified T : ViewModel> Fragment.getViewModel(factory: ViewModelProvider.NewInstanceFactory): T {
    return ViewModelProviders.of(this, factory).get(T::class.java)
}