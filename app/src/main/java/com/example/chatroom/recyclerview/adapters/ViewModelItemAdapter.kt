/**
 * Created by Chris Renfrow on 1/29/19.
 */

package com.example.chatroom.recyclerview.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.chatroom.extension.mutableLiveDataOf
import com.example.chatroom.recyclerview.BindingViewHolder
import com.example.chatroom.recyclerview.ViewModelDiffCallback
import com.example.chatroom.viewmodel.recycler.RecyclerViewItemViewModel

open class ViewModelItemAdapter<B : ViewDataBinding, V : RecyclerViewItemViewModel>(
    val items: LiveData<List<V>>
) :
    RecyclerView.Adapter<BindingViewHolder<B, V>>() {

    constructor(items: List<V>) : this(mutableLiveDataOf<List<V>>(items))

    @Suppress("unused")
    private val itemsMediator = MediatorLiveData<List<V>>().apply {
        addSource(this@ViewModelItemAdapter.items) {
            val callback = ViewModelDiffCallback(value ?: listOf(), it)
            val diffResult = DiffUtil.calculateDiff(callback, true)

            value = it

            diffResult.dispatchUpdatesTo(this@ViewModelItemAdapter)
        }
    }.also { it.observeForever {} }

    @Suppress("MemberVisibilityCanBePrivate")
    protected lateinit var recyclerView: RecyclerView

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder<B, V> {
        val binding: B = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            viewType,
            parent,
            false
        )
        if (parent.context is LifecycleOwner) {
            binding.lifecycleOwner = parent.context as LifecycleOwner
        }

        return BindingViewHolder(binding)
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)

        this.recyclerView = recyclerView
    }

    override fun getItemCount() = items.value?.size ?: 0

    override fun getItemViewType(position: Int) =
        items.value?.elementAtOrNull(position)?.layoutID ?: 0

    override fun onBindViewHolder(holder: BindingViewHolder<B, V>, position: Int) {
        val viewModel = items.value?.get(position)

        holder.bind(viewModel)
    }
}