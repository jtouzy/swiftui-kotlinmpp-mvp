package com.jtouzy.demo.app.ui

import androidx.compose.Model
import com.jtouzy.demo.app.model.Character

@Model
data class ScreenProvider(var screen: Screen = Screen.Loading)

sealed class Screen {
    object Loading : Screen()
    data class Home(val characters: List<Character>) : Screen()
    data class Details(val character: Character) : Screen()
}
