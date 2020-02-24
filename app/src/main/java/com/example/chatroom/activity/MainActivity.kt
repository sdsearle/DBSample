package com.example.chatroom.activity

import android.os.Bundle
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import com.example.chatroom.R
import com.example.chatroom.database.AppDatabase
import com.example.chatroom.database.entity.UserEntity
import com.example.chatroom.databinding.ActivityMainBinding
import com.example.chatroom.extension.replace
import com.example.chatroom.fragment.MainFragment
import com.example.chatroom.viewmodel.MainActivityViewModel
import timber.log.Timber
import javax.inject.Inject

class MainActivity : MVVMActivity<ActivityMainBinding, MainActivityViewModel>() {

    override val layoutID: Int = R.layout.activity_main

    @Inject
    lateinit var database: AppDatabase

    @Inject
    lateinit var mainFragment: MainFragment

    val users: MediatorLiveData<List<UserEntity>> = MediatorLiveData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Thread {
            if (database.userDao().getUsers().value?.isEmpty() == true || database.userDao().getUsers().value?.isEmpty() == null) {
                val users: MutableList<UserEntity> = mutableListOf()
                for (i: Int in 0..20) {
                    val user = UserEntity(i, "User $i")
                    users.add(i, user)
                }
                for (u in users) {
                    database.userDao().insertUser(u)
                }
            }


            /*val users = database.userDao().getUsers()*/
            /*users.addSource(database.userDao().getUsers()) { list -> list.forEach { Timber.d(it.name) }}
            users.value?.forEach { Timber.d(it.name) }*/

        }.start()

        database.userDao().getUsers().observe(this, Observer<List<UserEntity>> { list ->
            list.forEach { Timber.d(it.name) }
        })


        showMainFragment()

    }

    private fun showMainFragment() {
        //supportFragmentManager.beginTransaction().add(R.id.mainFragment, mainFragment).commit()
        supportFragmentManager.replace(
            R.id.mainFragment,
            true,
            "fragment_main",
            null,
            null,
            null,
            null
        ) {
            mainFragment
        }
    }
}
