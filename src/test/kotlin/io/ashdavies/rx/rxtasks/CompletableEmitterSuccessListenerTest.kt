package io.ashdavies.rx.rxtasks

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import io.reactivex.CompletableEmitter
import org.junit.Test
import org.mockito.BDDMockito.then
import org.mockito.Mockito.never

internal class CompletableEmitterSuccessListenerTest {

  private val emitter = mock<CompletableEmitter>()
  private val listener = CompletableEmitterSuccessListener(emitter)

  @Test
  fun `should call on complete`() {
    listener.onSuccess(mock())

    then(emitter).should().onComplete()
    then(emitter).should(never()).onError(any())
  }
}
