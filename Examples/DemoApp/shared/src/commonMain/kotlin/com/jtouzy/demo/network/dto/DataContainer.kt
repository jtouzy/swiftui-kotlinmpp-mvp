package com.jtouzy.demo.network.dto

import kotlinx.serialization.Serializable

@Serializable
class DataContainer {
    var results: List<CharacterMarvelDto>? = null
}