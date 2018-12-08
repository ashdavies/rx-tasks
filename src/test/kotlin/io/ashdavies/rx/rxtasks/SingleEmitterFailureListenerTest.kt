package io.ashdavies.rx.rxtasks

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.then
import io.reactivex.SingleEmitter
import org.junit.Test
import org.mockito.Mockito.never

class SingleEmitterFailureListenerTest {

  private val emitter = mock<SingleEmitter<Any>>()
  private val exception = mock<Exception>()

  private val listener = SingleEmitterFailureListener(emitter)

  @Test
  fun `should call on error with exception`() {
    listener.onFailure(exception)

    then(emitter).should(never()).onSuccess(any())
    then(emitter).should().onError(exception)
  }
}
