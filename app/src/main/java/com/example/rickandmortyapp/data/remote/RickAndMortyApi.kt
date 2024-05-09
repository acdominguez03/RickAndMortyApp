package com.example.rickandmortyapp.data.remote

import com.example.rickandmortyapp.data.dto.CharactersDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface RickAndMortyApi {
    @GET("character")
    suspend fun getAllCharacters(
        @Query("page") page: Int,
    ): CharactersDTO
}