package com.example.paginationwithpaging3library.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.liveData
import com.example.paginationwithpaging3library.network.ApiClient

class UserViewMode : ViewModel() {

    var liveData = Pager(PagingConfig(pageSize = 2)){
        UserDataSource(ApiClient.apiService)
    }.liveData
//    }.flow.cachedIn(viewModelScope).asLiveData()

}