package io.ashdavies.rx.rxtasks

import com.nhaarman.mockito_kotlin.mock
import io.reactivex.CompletableEmitter
import org.junit.Test
import org.mockito.BDDMockito.then
import org.mockito.Mockito.never
import java.lang.Exception

internal class CompletableEmitterFailureListenerTest {

  private val emitter = mock<CompletableEmitter>()
  private val exception = mock<Exception>()

  private val listener = CompletableEmitterFailureListener(emitter)

  @Test
  fun `should call on error with exception`() {
    listener.onFailure(exception)

    then(emitter).should(never()).onComplete()
    then(emitter).should().onError(exception)
  }
}
