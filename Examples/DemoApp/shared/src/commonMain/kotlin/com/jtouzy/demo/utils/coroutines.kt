package com.jtouzy.demo.utils

import kotlinx.coroutines.CoroutineDispatcher

expect val applicationDispatcher: CoroutineDispatcher
expect val ioDispatcher: CoroutineDispatcher