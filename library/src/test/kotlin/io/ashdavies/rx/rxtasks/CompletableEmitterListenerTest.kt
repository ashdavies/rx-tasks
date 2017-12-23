package io.ashdavies.rx.rxtasks

import com.google.android.gms.tasks.Tasks
import com.nhaarman.mockito_kotlin.any
import io.ashdavies.rx.rxtasks.internal.CompletableEmitterListener
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
internal class CompletableEmitterListenerTest {

  private lateinit var listener: CompletableEmitterListener

  @Mock private lateinit var emitter: CompletableEmitter
  @Mock private lateinit var exception: Exception

  @Before
  fun `set up`() {
    listener = CompletableEmitterListener(emitter)
  }

  @Test
  fun `should call on error with exception`() {
    listener.onComplete(Tasks.forException(exception))

    then(emitter).should(never()).onComplete()
    then(emitter).should().onError(exception)
  }

  @Test
  fun `should call on complete`() {
    listener.onComplete(Tasks.forResult(null as Void?))

    then(emitter).should().onComplete()
    then(emitter).should(never()).onError(any())
  }
}
