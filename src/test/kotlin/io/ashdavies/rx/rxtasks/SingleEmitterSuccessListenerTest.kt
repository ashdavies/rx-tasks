package io.ashdavies.rx.rxtasks

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.then
import io.reactivex.SingleEmitter
import org.junit.Test
import org.mockito.Mockito.never

class SingleEmitterSuccessListenerTest {

  private val emitter = mock<SingleEmitter<Any>>()
  private val listener = SingleEmitterSuccessListener(emitter)

  @Test
  fun `should call on success`() {
    listener.onSuccess(RESULT)

    then(emitter).should().onSuccess(RESULT)
    then(emitter).should(never()).onError(any())
  }

  companion object {

    private const val RESULT = "SUCCESS"
  }
}
