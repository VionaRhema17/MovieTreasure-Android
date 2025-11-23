package com.viona.movietreasure.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.viona.movietreasure.data.paging.SearchFilmSource
import com.viona.movietreasure.data.remote.ApiService
import com.viona.movietreasure.models.Search

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchRepository @Inject constructor(
    private val api: ApiService
) {


    fun multiSearch(searchParams: String, includeAdult: Boolean): Flow<PagingData<Search>> {
        return Pager(
            config = PagingConfig(enablePlaceholders = false, pageSize = 20),
            pagingSourceFactory = {
                SearchFilmSource(api = api, searchParams = searchParams, includeAdult)
            }
        ).flow
    }
}