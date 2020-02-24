/**
 * Created by Chris Renfrow on 1/17/19.
 */

package com.example.chatroom.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.chatroom.BR
import com.example.chatroom.viewmodel.BaseViewModel

abstract class MVVMFragment<B : ViewDataBinding, VM : BaseViewModel> : BaseFragment() {

    protected abstract val layoutID: Int
    protected lateinit var binding: B
    protected lateinit var viewModel: VM

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        super.onCreateView(inflater, container, savedInstanceState)

        binding = DataBindingUtil.inflate(inflater, layoutID, container, false)

        binding.lifecycleOwner = this

        binding.setVariable(BR.vm, viewModel)

        return binding.root
    }
}