package com.joaquimverges.helium.test

import com.joaquimverges.helium.core.event.BlockEvent
import com.joaquimverges.helium.core.LogicBlock
import com.joaquimverges.helium.core.state.BlockState
import kotlinx.coroutines.flow.onEach
import org.mockito.internal.matchers.apachecommons.ReflectionEquals

/**
 * Utility class used to test UiBlocks in isolation
 */
class TestLogicBLock<S : BlockState, E : BlockEvent> : LogicBlock<S, E>() {

    private var lastReceivedEvent: BlockEvent? = null
    private var lastBlockState: BlockState? = null

    init {
        observeState().onEach {
            lastBlockState = it
        }.launchInBlock()
    }

    override fun onUiEvent(event: E) {
        lastReceivedEvent = event
    }

    fun assertState(state: BlockState) {
        assert(ReflectionEquals(state).matches(lastBlockState))
    }

    fun assertOnEvent(event: BlockEvent) {
        assert(ReflectionEquals(event).matches(lastReceivedEvent))
    }

    fun assertNoEvents() {
        if (lastReceivedEvent != null) {
            throw IllegalStateException("Expected no events received but got: $lastReceivedEvent")
        }
    }
}
