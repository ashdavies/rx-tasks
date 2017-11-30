package io.ashdavies.rx.rxtasks

import io.reactivex.CompletableEmitter
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.then
import org.mockito.Mock
import org.mockito.Mockito.never
import org.mockito.junit.MockitoJUnitRunner
import java.lang.Exception

@RunWith(MockitoJUnitRunner::class)
internal class CompletableEmitterFailureListenerTest {

  private lateinit var listener: CompletableEmitterFailureListener

  @Mock private lateinit var emitter: CompletableEmitter
  @Mock private lateinit var exception: Exception

  @Before
  fun `set up`() {
    listener = CompletableEmitterFailureListener(emitter)
  }

  @Test
  fun `should call on error with exception`() {
    listener.onFailure(exception)

    then(emitter).should(never()).onComplete()
    then(emitter).should().onError(exception)
  }
}
