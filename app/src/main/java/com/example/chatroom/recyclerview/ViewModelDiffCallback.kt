/**
 * Created by Chris Renfrow on 1/30/18.
 */

package com.example.chatroom.recyclerview

import androidx.recyclerview.widget.DiffUtil
import com.example.chatroom.viewmodel.recycler.RecyclerViewItemViewModel

class ViewModelDiffCallback(
    private val oldItems: List<RecyclerViewItemViewModel>,
    private val newItems: List<RecyclerViewItemViewModel>
) :
    DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldListSize > oldItemPosition &&
                newListSize > newItemPosition &&
                oldItems[oldItemPosition].isSameEntity(newItems[newItemPosition])

    override fun getOldListSize() = oldItems.size

    override fun getNewListSize() = newItems.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {

        val oldItem =
            if (oldItemPosition in 0 until (oldItems.size)) oldItems[oldItemPosition] else null
        val newItem =
            if (newItemPosition in 0 until (newItems.size)) newItems[newItemPosition] else null

        return oldItem == newItem
    }
}