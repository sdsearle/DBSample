package com.example.chatroom.recyclerview

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.chatroom.BR
import com.example.chatroom.viewmodel.BaseViewModel

/**
 * Created by Chris Renfrow on 1/19/18.
 */
class BindingViewHolder<B : ViewDataBinding, in V : BaseViewModel>(var binding: B) :
    RecyclerView.ViewHolder(
        binding.root
    ) {

    fun bind(viewModel: V?) {
        viewModel?.let {
            binding.setVariable(BR.vm, it)
            it.notifyChange()
        }

        binding.executePendingBindings()
    }
}