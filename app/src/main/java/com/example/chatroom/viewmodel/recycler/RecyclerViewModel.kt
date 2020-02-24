/**
 * Created by Chris Renfrow on 2019-12-03.
 */

package com.example.chatroom.viewmodel.recycler

import android.graphics.drawable.Drawable
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.example.chatroom.R
import com.example.chatroom.extension.dependentLiveData
import com.example.chatroom.extension.mutableLiveDataOf
import com.example.chatroom.providers.ColorProvider
import com.example.chatroom.providers.LayoutManagerProvider
import com.example.chatroom.recyclerview.adapters.ViewModelItemAdapter
import com.example.chatroom.viewmodel.BaseViewModel

abstract class RecyclerViewModel<B : ViewDataBinding, V : RecyclerViewItemViewModel> :
    BaseViewModel() {

    protected abstract val layoutManagerProvider: LayoutManagerProvider
    protected abstract val colorProvider: ColorProvider

    abstract val adapter: ViewModelItemAdapter<B, V>

    open val layoutManager: LiveData<RecyclerView.LayoutManager>
        get() = mutableLiveDataOf(
            layoutManagerProvider.getLinearLayoutManager(
                RecyclerView.VERTICAL,
                false
            )
        )

    open val snapHelper: MutableLiveData<SnapHelper?> = mutableLiveDataOf(null)

    open val emptyDrawable: MutableLiveData<Drawable?> = mutableLiveDataOf(null)

    open val emptyHeader: MutableLiveData<String?> = mutableLiveDataOf(null)

    open val emptyDescription: MutableLiveData<String?> = mutableLiveDataOf(null)

    open val emptyTint: MutableLiveData<Int> by lazy { mutableLiveDataOf(colorProvider.getColor(R.color.primary)) }

    open val emptyVisibility
        get() = dependentLiveData(adapter.items, emptyDrawable) {
            if (adapter.items.value.isNullOrEmpty() && emptyDrawable.value != null) View.VISIBLE else View.GONE
        }

    open val refreshing: MutableLiveData<Boolean> = mutableLiveDataOf(false)

    open val refreshingVisibility
        get() = dependentLiveData(refreshing) {
            if (refreshing.value == true) View.VISIBLE else View.GONE
        }
}