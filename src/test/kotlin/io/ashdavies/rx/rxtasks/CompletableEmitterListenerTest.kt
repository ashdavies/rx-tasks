package io.ashdavies.rx.rxtasks

import com.google.android.gms.tasks.Tasks
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.then
import io.reactivex.rxjava3.core.CompletableEmitter
import org.junit.Test
import java.util.concurrent.CancellationException

internal class CompletableEmitterListenerTest {

  private val emitter = mock<CompletableEmitter>()
  private val listener = CompletableEmitterListener(emitter)

  @Test
  fun `should represent result as completion`() {
    listener.onComplete(Tasks.forResult(null))

    then(emitter)
        .should()
        .onComplete()
  }

  @Test
  fun `should represent cancelled as error`() {
    listener.onComplete(Tasks.forCanceled())

    then(emitter)
        .should()
        .onError(any<CancellationException>())
  }

  @Test
  fun `should represent exception as error`() {
    listener.onComplete(Tasks.forException(RuntimeException()))

    then(emitter)
        .should()
        .onError(any<RuntimeException>())
  }
}
