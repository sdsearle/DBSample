/**
 * Created by Chris Renfrow on 1/24/18.
 */

package com.example.chatroom.providers

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager

interface LayoutManagerProvider {

    fun getLinearLayoutManager(orientation: Int, reverseLayout: Boolean): LinearLayoutManager
    fun getGridLayoutManager(numberColumns: Int): GridLayoutManager

}