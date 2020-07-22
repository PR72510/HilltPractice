package com.example.hilltpractice.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.hilltpractice.R
import com.example.hilltpractice.common.DataState
import com.example.hilltpractice.common.MainStateEvent
import com.example.hilltpractice.models.Blog
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import java.lang.StringBuilder

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    @ExperimentalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        handleObservers()
        viewModel.setStateEvent(MainStateEvent.GetBlogsEvent)
    }

    private fun handleObservers(){
        viewModel.dataState.observe(this, Observer { dataState ->
            when(dataState){
                is DataState.Success<List<Blog>> -> {
                    appendBlogTitles(dataState.data)
                }
                is DataState.Error -> {
                    displayError(dataState.exception.message)
                }
                is DataState.Loading -> {
                }
            }
        })
    }

    private fun displayError(message: String?) {
        if(message?.isNotEmpty()!!)
            tvTitle.text = message
        else
            tvTitle.text = "Unknown Error"
    }

    private fun appendBlogTitles(data: List<Blog>) {
        val titles = StringBuilder()
        data.forEach { blog ->
            titles.append(blog.title.plus("\n"))
        }
        tvTitle.text = titles
    }
}