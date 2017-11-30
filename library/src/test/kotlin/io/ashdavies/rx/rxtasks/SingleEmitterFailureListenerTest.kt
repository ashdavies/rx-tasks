package io.ashdavies.rx.rxtasks

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.then
import io.reactivex.SingleEmitter
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.never
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SingleEmitterFailureListenerTest {

  private lateinit var listener: SingleEmitterFailureListener<String>

  @Mock private lateinit var emitter: SingleEmitter<String>
  @Mock private lateinit var exception: Exception

  @Before
  fun `set up`() {
    listener = SingleEmitterFailureListener(emitter)
  }

  @Test
  fun `should call on error with exception`() {
    listener.onFailure(exception)

    then(emitter).should(never()).onSuccess(any())
    then(emitter).should().onError(exception)
  }
}
