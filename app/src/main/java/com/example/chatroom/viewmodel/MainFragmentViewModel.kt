/**
 * Created by Spencer Searle on 2020-02-18.
 */

package com.example.chatroom.viewmodel

import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chatroom.extension.map
import com.example.chatroom.extension.mutableLiveDataOf
import com.example.chatroom.interactors.UserListInteractor
import com.example.chatroom.providers.ColorProvider
import com.example.chatroom.providers.LayoutManagerProvider
import com.example.chatroom.recyclerview.adapters.ViewModelItemAdapter
import com.example.chatroom.viewmodel.recycler.RecyclerViewItemViewModel
import com.example.chatroom.viewmodel.recycler.RecyclerViewModel
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject

class MainFragmentViewModel @AssistedInject constructor(
    @Assisted val userListInteractor: UserListInteractor,
    //private val userItemViewModelFactory: UserItemViewModel.Factory,
    override val layoutManagerProvider: LayoutManagerProvider,
    override val colorProvider: ColorProvider
) : RecyclerViewModel<ViewDataBinding, RecyclerViewItemViewModel>() {

    override val adapter =
        ViewModelItemAdapter<ViewDataBinding, RecyclerViewItemViewModel>(getViewModels())

    //private var observer = userListInteractor.userInteractors.observe(this, Observer {  })


    override val layoutManager: LiveData<RecyclerView.LayoutManager>
        get() = mutableLiveDataOf(
            layoutManagerProvider.getLinearLayoutManager(
                LinearLayoutManager.VERTICAL,
                false
            )
        )

    private fun getViewModels(): LiveData<List<RecyclerViewItemViewModel>> =
        userListInteractor.userInteractors.map { list ->
            list.map {
                UserItemViewModel(it)
            }
        }

    @AssistedInject.Factory
    interface Factory {
        fun create(userListInteractor: UserListInteractor): MainFragmentViewModel
    }

}

class MainFragmentViewModelFactory(
    private val interactor: UserListInteractor,
    private val factory: MainFragmentViewModel.Factory
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = factory.create(interactor) as T
}