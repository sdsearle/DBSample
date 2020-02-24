/**
 * Created by Chris Renfrow on 2/12/19.
 */

package com.example.chatroom.fragment

import android.content.Context
import android.os.Bundle
import android.view.*
import dagger.android.support.DaggerFragment
import timber.log.Timber

open class BaseFragment : DaggerFragment() {
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Timber.d("${this::class.simpleName}.onActivityCreated()")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d("${this::class.simpleName}.onCreate()")

        /*EventProvider.getEventLiveData().observe(this) {
            for(e in it)
            if (!e.isConsumed) {
                handleEvent(e)
            }
        }*/
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Timber.d("${this::class.simpleName}.onCreateView()")

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        Timber.d("${this::class.simpleName}.onStart()")
    }

    override fun onResume() {
        super.onResume()
        Timber.d("${this::class.simpleName}.onResume()")
    }

    override fun onPause() {
        super.onPause()
        Timber.d("${this::class.simpleName}.onPause()")
    }

    override fun onStop() {
        super.onStop()
        Timber.d("${this::class.simpleName}.onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Timber.d("${this::class.simpleName}.onDestroy()")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Timber.d("${this::class.simpleName}.onDestroyView()")
    }

    override fun onDetach() {
        super.onDetach()
        Timber.d("${this::class.simpleName}.onDetach()")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Timber.d("${this::class.simpleName}.onAttach()")
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        Timber.d("${this::class.simpleName}.onCreateOptionsMenu()")
    }

    /*open fun handleEvent(event: Event) { *//* Intentionally blank, override in fragment *//*
        Timber.d("Handle the event")
    }*/
}