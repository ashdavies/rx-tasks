package io.ashdavies.rx.rxtasks

import com.google.common.truth.Truth.assertThat
import io.ashdavies.rx.rxtasks.internal.CompletableEmitterListener
import io.ashdavies.rx.rxtasks.internal.CompletableTaskListenerFactory
import io.ashdavies.rx.rxtasks.internal.TaskListenerFactory
import io.reactivex.CompletableEmitter
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
internal class CompletableTaskListenerFactoryTest {

  private lateinit var factory: TaskListenerFactory<Void, CompletableEmitter>

  @Mock private lateinit var emitter: CompletableEmitter

  @Before
  fun `set up`() {
    factory = CompletableTaskListenerFactory()
  }

  @Test
  fun `should return completable emitter listener`() {
    assertThat(factory.createOnCompleteListener(emitter)).isInstanceOf(CompletableEmitterListener::class.java)
  }
}
