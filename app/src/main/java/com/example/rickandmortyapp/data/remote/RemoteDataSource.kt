package com.example.rickandmortyapp.data.remote

import com.example.rickandmortyapp.domain.model.Character
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val rickAndMortyApi: RickAndMortyApi
) {
    suspend fun getAllCharacters(page: Int): List<Character> {
        return rickAndMortyApi.getAllCharacters(page).results.map {
            it.toCharacter()
        }
    }
}