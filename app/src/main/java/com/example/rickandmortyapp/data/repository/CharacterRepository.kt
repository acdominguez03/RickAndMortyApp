package com.example.rickandmortyapp.data.repository

import com.example.rickandmortyapp.util.Constants
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.rickandmortyapp.data.CharactersPagingSource
import com.example.rickandmortyapp.data.remote.RemoteDataSource
import com.example.rickandmortyapp.domain.model.Character
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface CharacterRepository {
    fun getCharacters(): Flow<PagingData<Character>>
}

class CharacterRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
): CharacterRepository {
    override fun getCharacters(): Flow<PagingData<Character>> {
        return Pager(
            config = PagingConfig(pageSize = Constants.MAX_PAGE_SIZE, prefetchDistance = 2),
            pagingSourceFactory = {
                CharactersPagingSource(remoteDataSource = remoteDataSource)
            }
        ).flow
    }
}