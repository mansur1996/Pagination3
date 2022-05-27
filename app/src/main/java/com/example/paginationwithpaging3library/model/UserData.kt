package com.example.paginationwithpaging3library.model

import com.example.paginationwithpaging3library.model.Data
import com.example.paginationwithpaging3library.model.Support

data class UserData(
    val perPage: Int,
    val total: Int,
    val data: List<Data>,
    val page: Int,
    val totalPages: Int,
    val support: Support
)
