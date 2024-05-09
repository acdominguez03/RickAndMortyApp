package com.example.rickandmortyapp.domain.use_cases

import androidx.paging.PagingData
import com.example.rickandmortyapp.data.repository.CharacterRepository
import com.example.rickandmortyapp.domain.model.Character
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val repository: CharacterRepository
) {
    operator fun invoke(): Flow<PagingData<Character>> {
        return repository.getCharacters()
    }
}