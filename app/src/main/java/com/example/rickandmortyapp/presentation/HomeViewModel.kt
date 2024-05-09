package com.example.rickandmortyapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.rickandmortyapp.domain.use_cases.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject
import com.example.rickandmortyapp.domain.model.Character
import kotlinx.coroutines.launch

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCase: GetCharactersUseCase
): ViewModel() {
    private val _characterState: MutableStateFlow<PagingData<Character>> = MutableStateFlow(value = PagingData.empty())
    val charactersState: MutableStateFlow<PagingData<Character>> get() = _characterState

    init {
        getCharacters()
    }

    private fun getCharacters() {
        viewModelScope.launch {
            useCase.invoke().collect { characters ->
                _characterState.value = characters
            }
        }
    }

}