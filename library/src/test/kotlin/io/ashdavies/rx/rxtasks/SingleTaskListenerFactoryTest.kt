package io.ashdavies.rx.rxtasks

import com.google.common.truth.Truth.assertThat
import io.ashdavies.rx.rxtasks.internal.SingleEmitterListener
import io.ashdavies.rx.rxtasks.internal.SingleTaskListenerFactory
import io.ashdavies.rx.rxtasks.internal.TaskListenerFactory
import io.reactivex.SingleEmitter
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SingleTaskListenerFactoryTest {

  private lateinit var factory: TaskListenerFactory<Void, SingleEmitter<Void>>

  @Mock private lateinit var emitter: SingleEmitter<Void>

  @Before
  fun `set up`() {
    factory = SingleTaskListenerFactory()
  }

  @Test
  fun `should return completable emitter listener`() {
    assertThat(factory.createOnCompleteListener(emitter)).isInstanceOf(SingleEmitterListener::class.java)
  }
}
