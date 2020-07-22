package com.example.hilltpractice.common

/**
 * Created by PR72510 on 22/7/20.
 */
sealed class MainStateEvent {
    object GetBlogsEvent: MainStateEvent()
    object None: MainStateEvent()
}