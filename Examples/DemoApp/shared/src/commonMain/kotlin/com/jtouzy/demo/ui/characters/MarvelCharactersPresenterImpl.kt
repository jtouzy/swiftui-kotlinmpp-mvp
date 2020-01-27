package com.jtouzy.demo.ui.characters

import com.jtouzy.demo.ui.Store

class MarvelCharactersPresenterImpl(
    private val store: Store<MarvelCharactersViewState>
) : MarvelCharactersPresenter {

    override fun loadCharacters() {
        store.currentState = Content(listOf("Hulk", "Iron Man", "Thor"))
    }
}
