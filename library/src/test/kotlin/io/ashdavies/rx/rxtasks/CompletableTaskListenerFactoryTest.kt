package io.ashdavies.rx.rxtasks

import com.google.common.truth.Truth.assertThat
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
  fun `should return completable emitter success listener`() {
    assertThat(factory.createOnSuccessListener(emitter)).isInstanceOf(CompletableEmitterSuccessListener::class.java)
  }

  @Test
  fun `should return completable emitter failure listener`() {
    assertThat(factory.createOnFailureListener(emitter)).isInstanceOf(CompletableEmitterFailureListener::class.java)
  }
}
