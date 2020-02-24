/**
 * Created by Spencer Searle on 2020-02-19.
 */

package com.example.chatroom.viewmodel

import com.example.chatroom.R
import com.example.chatroom.interactors.UserInteractor
import com.example.chatroom.viewmodel.recycler.RecyclerViewItemViewModel

class UserItemViewModel constructor(
    val interactor: UserInteractor
) : RecyclerViewItemViewModel(R.layout.list_item_user) {

    val tvName = "test"

    override fun isSameEntity(other: RecyclerViewItemViewModel): Boolean {
        return (other as? UserItemViewModel)?.interactor?.userId == interactor.userId
    }

    override fun clicked() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /*interface Factory{
        fun create(interactor: UserInteractor):UserItemViewModel
    }
}

class UserItemViewModelFactory(
    private val interactor: UserInteractor,
    private val factory: UserItemViewModel.Factory
): ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = factory.create(interactor) as T*/
}
