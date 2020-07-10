package com.fionicholas.simplebasemvvm.utils

import android.content.Context

object ContextProvider {

    private var mContext: Context? = null


    private fun init(context: Context) {
        mContext = context
    }

    private fun getContext(): Context {
        if (mContext == null) {
            throw IllegalStateException("call init first")
        }
        return mContext!!
    }


    @JvmStatic
    fun initialize(context: Context) {
        init(context)
    }

    @JvmStatic
    fun get(): Context {
        return getContext()
    }

}