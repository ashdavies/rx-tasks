package io.ashdavies.rx.rxtasks

import com.google.android.gms.tasks.Tasks
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.then
import io.ashdavies.rx.rxtasks.internal.SingleEmitterListener
import io.reactivex.SingleEmitter
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.never
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SingleEmitterListenerTest {

  private lateinit var listener: SingleEmitterListener<String>

  @Mock private lateinit var emitter: SingleEmitter<String>
  @Mock private lateinit var exception: Exception

  @Before
  fun `set up`() {
    listener = SingleEmitterListener(emitter)
  }

  @Test
  fun `should call on success`() {
    listener.onComplete(Tasks.forResult(RESULT))

    then(emitter).should().onSuccess(RESULT)
    then(emitter).should(never()).onError(any())
  }

  @Test
  fun `should call on error with exception`() {
    listener.onComplete(Tasks.forException(exception))

    then(emitter).should(never()).onSuccess(any())
    then(emitter).should().onError(exception)
  }

  private companion object {
    const val RESULT = "SUCCESS"
  }
}
