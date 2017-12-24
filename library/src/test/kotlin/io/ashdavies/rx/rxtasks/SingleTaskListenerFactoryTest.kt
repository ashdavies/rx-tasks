package io.ashdavies.rx.rxtasks

import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockito_kotlin.mock
import io.reactivex.SingleEmitter
import org.junit.Test

internal class SingleTaskListenerFactoryTest {

  private val emitter = mock<SingleEmitter<Any>>()
  private val factory = SingleTaskListenerFactory<Any>()

  @Test
  fun `should return completable emitter success listener`() {
    assertThat(factory.createOnSuccessListener(emitter)).isInstanceOf(SingleEmitterSuccessListener::class.java)
  }

  @Test
  fun `should return completable emitter failure listener`() {
    assertThat(factory.createOnFailureListener(emitter)).isInstanceOf(SingleEmitterFailureListener::class.java)
  }
}
