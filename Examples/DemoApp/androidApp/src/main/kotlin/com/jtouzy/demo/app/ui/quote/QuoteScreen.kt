package com.jtouzy.demo.app.ui.quote

import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.animation.Crossfade
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.Center
import androidx.ui.layout.Column
import androidx.ui.layout.Padding
import androidx.ui.material.Divider
import androidx.ui.material.MaterialTheme
import androidx.ui.material.TopAppBar
import androidx.ui.res.stringResource
import com.jtouzy.demo.app.R
import com.jtouzy.demo.app.ui.NavigationManager
import com.jtouzy.demo.app.ui.common.LoadingScreen
import com.jtouzy.demo.app.ui.common.VectorImageButton
import com.jtouzy.demo.ui.Store
import com.jtouzy.demo.ui.model.Quote
import com.jtouzy.demo.ui.quotes.QuotesPresenter
import com.jtouzy.demo.ui.quotes.QuotesViewState

class QuoteScreen(
    private val store: Store<QuotesViewState>,
    presenter: QuotesPresenter
) {

    init {
        presenter.loadQuotes()
    }

    @Composable
    fun MainScreen() {
        Column {
            TopAppBar(
                title = { Text(store.currentState.title) },
                navigationIcon = {
                    VectorImageButton(R.drawable.ic_back) {
                        NavigationManager.popBackStack()
                    }
                }
            )
            Crossfade(store.currentState) { state ->
                when (state) {
                    is QuotesViewState.Loading -> LoadingScreen()
                    is QuotesViewState.Content -> QuoteList(state.quotes)
                    is QuotesViewState.NoQuote -> NoQuote()
                }
            }
        }
    }

    @Composable
    private fun QuoteList(quotes: List<Quote>) {
        VerticalScroller {
            Column {
                quotes.forEach { QuoteItem(it) }
            }
        }
    }

    @Composable
    private fun NoQuote() {
        Center {
            Text(text = +stringResource(R.string.no_quotes))
        }
    }

    @Composable
    private fun QuoteItem(quote: Quote) {
        Column {
            Padding(16.dp) {
                Text(text = quote.quote)
            }
            Padding(16.dp) {
                Text(text = quote.series)
            }
            Divider(color = (+MaterialTheme.colors()).onBackground)
        }
    }
}
