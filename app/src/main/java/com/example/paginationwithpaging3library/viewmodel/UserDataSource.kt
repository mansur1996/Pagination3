package com.example.paginationwithpaging3library.viewmodel

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.paginationwithpaging3library.model.Data
import com.example.paginationwithpaging3library.network.service.ApiService
import java.lang.Exception

class UserDataSource(val apiService: ApiService) : PagingSource<Int, Data>() {
    override fun getRefreshKey(state: PagingState<Int, Data>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Data> {
        try {
            val nextPageNumber = params.key ?: 1
            val users = apiService.getUsers(nextPageNumber)
            return LoadResult.Page(users.data, null, nextPageNumber + 1)
        }catch (e : Exception){
            return LoadResult.Error(e)
        }

    }
}