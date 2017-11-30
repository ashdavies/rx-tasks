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
class SingleEmitterSuccessListenerTest {

  private lateinit var listener: SingleEmitterSuccessListener<String>

  @Mock private lateinit var emitter: SingleEmitter<String>

  @Before
  fun `set up`() {
    listener = SingleEmitterSuccessListener(emitter)
  }

  @Test
  fun `should call on success`() {
    listener.onSuccess(RESULT)

    then(emitter).should().onSuccess(RESULT)
    then(emitter).should(never()).onError(any())
  }

  companion object {

    private val RESULT = "SUCCESS"
  }
}
