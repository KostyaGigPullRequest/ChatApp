package ru.zinoview.viewmodelmemoryleak.data.chat.state

import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import ru.zinoview.viewmodelmemoryleak.ui.chat.state.UiState
import ru.zinoview.viewmodelmemoryleak.ui.chat.state.UiStates

/**
 * Test for [ru.zinoview.viewmodelmemoryleak.data.chat.state.UiStateRepository.Test]
 * */

class UiStateRepositoryTest {

    private var repository: UiStateRepository? = null

    @Before
    fun setUp() {
        repository = UiStateRepository.Test()
    }

    @Test
    fun test_save_empty_state() {
        val expected = UiStates.Test.Empty
        var actual = repository?.read(Unit)

        assertEquals(expected, actual)

        repository?.save(UiStates.Test.Base(
            UiState.EditText(),
            UiState.MessageSession()
        ))

        actual = repository?.read(Unit)

        repository?.save(UiStates.Test.Base(
            UiState.EditText(),
            UiState.MessageSession()
        ))
        assertEquals(expected, actual)
    }

    @Test
    fun test_save_full_state() {
        var expected = UiStates.Test.Base(
            UiState.EditText("Restored text"),
            UiState.MessageSession("edited message's text","12345")
        )

        repository?.save(expected)

        var actual = repository?.read(Unit)
        assertEquals(expected, actual)

        expected = UiStates.Test.Base(
            UiState.EditText("New text"),
            UiState.MessageSession("another text","12345")
        )

        repository?.save(expected)

        actual = repository?.read(Unit)
        assertEquals(expected, actual)
    }

    @Test
    fun test_save_state_partly() {
        var expected = UiStates.Test.Base(
            UiState.EditText(),
            UiState.MessageSession("edited message's text","12345")
        )

        repository?.save(expected)

        var actual = repository?.read(Unit)
        assertEquals(expected, actual)

        expected = UiStates.Test.Base(
            UiState.EditText("New text"),
            UiState.MessageSession()
        )

        repository?.save(expected)

        actual = repository?.read(Unit)
        assertEquals(expected, actual)
    }

    @After
    fun clean() {
        repository = null
    }
}