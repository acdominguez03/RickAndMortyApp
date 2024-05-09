package com.example.rickandmortyapp.data.dto

import com.example.rickandmortyapp.domain.model.Character

data class Result(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
) {
    fun toCharacter(): Character {
        return Character(
            id = id,
            name = name,
            image = image,
            status = status
        )
    }
}