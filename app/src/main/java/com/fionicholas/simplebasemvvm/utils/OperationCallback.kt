package com.fionicholas.simplebasemvvm.utils

interface OperationCallback {
    fun onSuccess(obj:Any?)
    fun onError(obj:Any?)
}