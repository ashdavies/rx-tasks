package io.ashdavies.rx.rxtasks

import com.nhaarman.mockito_kotlin.any
import io.reactivex.CompletableEmitter
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.then
import org.mockito.Mock
import org.mockito.Mockito.never
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
internal class CompletableEmitterSuccessListenerTest {

  private lateinit var listener: CompletableEmitterSuccessListener

  @Mock private lateinit var emitter: CompletableEmitter

  @Before
  fun `set up`() {
    listener = CompletableEmitterSuccessListener(emitter)
  }

  @Test
  @Ignore
  fun `should call on complete`() {
    listener.onSuccess(null as Void)

    then(emitter).should().onComplete()
    then(emitter).should(never()).onError(any())
  }
}
