/**
 * Created by Chris Renfrow on 1/29/19.
 */

package com.example.chatroom.viewmodel.recycler

import androidx.annotation.LayoutRes
import com.example.chatroom.viewmodel.BaseViewModel

abstract class RecyclerViewItemViewModel(@LayoutRes val layoutID: Int) : BaseViewModel() {
    abstract fun isSameEntity(other: RecyclerViewItemViewModel): Boolean

    abstract fun clicked()
}