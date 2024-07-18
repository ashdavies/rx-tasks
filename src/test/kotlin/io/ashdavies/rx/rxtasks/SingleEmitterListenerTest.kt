package io.ashdavies.rx.rxtasks

import com.google.android.gms.tasks.Tasks
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.then
import io.reactivex.rxjava3.core.SingleEmitter
import org.junit.Test
import java.util.concurrent.CancellationException

internal class SingleEmitterListenerTest {

  private val emitter = mock<SingleEmitter<Int>>()
  private val listener = SingleEmitterListener(emitter)

  @Test
  fun `should represent result as success`() {
    listener.onComplete(Tasks.forResult<Int>(42))

    then(emitter)
        .should()
        .onSuccess(42)
  }

  @Test
  fun `should represent null as error`() {
    listener.onComplete(Tasks.forResult<Int>(null))

    then(emitter)
        .should()
        .onError(any<IllegalStateException>())
  }

  @Test
  fun `should represent cancelled as error`() {
    listener.onComplete(Tasks.forCanceled<Int>())

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
