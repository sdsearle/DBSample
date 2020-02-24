/**
 * Created by Spencer Searle on 2020-02-18.
 */

package com.example.chatroom.fragment

import android.os.Bundle
import com.example.chatroom.R
import com.example.chatroom.databinding.FragmentMainBinding
import com.example.chatroom.extension.getViewModel
import com.example.chatroom.interactors.UserListInteractor
import com.example.chatroom.viewmodel.MainFragmentViewModel
import com.example.chatroom.viewmodel.MainFragmentViewModelFactory
import javax.inject.Inject

class MainFragment @Inject constructor(val userListInteractor: UserListInteractor) :
    MVVMFragment<FragmentMainBinding, MainFragmentViewModel>() {

    @Inject
    lateinit var mainFragmentViewModelFactory: MainFragmentViewModel.Factory


    companion object {
        //fun newInstance() = MainFragment(UserListInteractor())
    }

    override val layoutID: Int = R.layout.fragment_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        userListInteractor.load()
        val factory =
            MainFragmentViewModelFactory(userListInteractor, mainFragmentViewModelFactory)

        viewModel = getViewModel(factory)
    }
}