package com.example.mvvmapplication.extensions

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

import androidx.databinding.BindingAdapter

@BindingAdapter("refreshing")
fun SwipeRefreshLayout.refreshing(visible: Boolean) {
    isRefreshing = visible
}