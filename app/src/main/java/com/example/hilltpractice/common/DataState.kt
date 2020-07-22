package com.example.hilltpractice.common

import java.lang.Exception

/**
 * Created by PR72510 on 22/7/20.
 */
sealed class DataState<out R> {

    data class Success<out T>(val data: T): DataState<T>()
    data class Error(val exception: Exception): DataState<Nothing>()
    object Loading : DataState<Nothing>()
}