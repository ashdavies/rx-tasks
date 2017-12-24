package io.ashdavies.rx.rxtasks

import com.google.android.gms.tasks.OnSuccessListener
import com.google.android.gms.tasks.Task
import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockito_kotlin.argumentCaptor
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.then
import org.junit.Test

internal class TaskExtensionsTest {

  private val task = mock<Task<Void>>()

  @Test
  fun `should create completable task`() {
    val captor = argumentCaptor<OnSuccessListener<Void>>()

    task.toCompletable().subscribe()

    then(task).should().addOnSuccessListener(captor.capture())
    assertThat(captor.lastValue).isInstanceOf(CompletableEmitterSuccessListener::class.java)
  }

  @Test
  fun `should create single task`() {
    val captor = argumentCaptor<OnSuccessListener<Void>>()

    task.toSingle().subscribe()

    then(task).should().addOnSuccessListener(captor.capture())
    assertThat(captor.lastValue).isInstanceOf(SingleEmitterSuccessListener::class.java)
  }
}
