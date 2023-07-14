package com.example.suitmediatest.data.paging

import androidx.paging.PagingConfig
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.suitmediatest.network.model.user.DataItem
import com.example.suitmediatest.network.service.ApiService

class UserPagingSource (private val apiSercive : ApiService) : PagingSource<Int, DataItem>() {

    private companion object {
        const val INITIAL_PAGE_INDEX = 1
    }

    override fun getRefreshKey(state: PagingState<Int, DataItem>): Int? =
        state.anchorPosition?.let { anchorPosition ->
            val anchorPage =state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, DataItem> =
        try {
            val page  = params.key ?: INITIAL_PAGE_INDEX
            val responseUser =apiSercive.getUser(page).data!!
            LoadResult.Page(
                data = responseUser,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if(responseUser.isEmpty()) null else page + 1
            )
        } catch (e : Exception){
            LoadResult.Error(e)
        }
}