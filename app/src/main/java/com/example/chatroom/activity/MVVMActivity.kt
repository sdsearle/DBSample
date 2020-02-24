/**
 * Created by Spencer Searle on 2020-02-18.
 */

package com.example.chatroom.activity

import android.os.Bundle
import android.os.PersistableBundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import com.example.chatroom.BR
import dagger.android.support.DaggerAppCompatActivity

abstract class MVVMActivity<B : ViewDataBinding, VM : ViewModel> : DaggerAppCompatActivity() {

    protected abstract val layoutID: Int
    protected lateinit var binding: B
    protected lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        binding = DataBindingUtil.setContentView(this, layoutID)
        binding.lifecycleOwner = this
        if (::viewModel.isInitialized) {
            binding.setVariable(BR.vm, viewModel)
        }
    }
}