package io.ashdavies.rx.rxtasks

import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockito_kotlin.mock
import io.reactivex.CompletableEmitter
import org.junit.Test

internal class CompletableTaskListenerFactoryTest {

  private val emitter = mock<CompletableEmitter>()
  private val factory = CompletableTaskListenerFactory()

  @Test
  fun `should return completable emitter success listener`() {
    assertThat(factory.createOnSuccessListener(emitter)).isInstanceOf(CompletableEmitterSuccessListener::class.java)
  }

  @Test
  fun `should return completable emitter failure listener`() {
    assertThat(factory.createOnFailureListener(emitter)).isInstanceOf(CompletableEmitterFailureListener::class.java)
  }
}
