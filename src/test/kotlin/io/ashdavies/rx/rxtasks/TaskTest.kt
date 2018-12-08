package io.ashdavies.rx.rxtasks

import com.google.android.gms.tasks.Task
import com.google.android.gms.tasks.Tasks
import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockito_kotlin.mock
import org.junit.Test
import java.util.concurrent.CancellationException

internal class TaskTest {

  @Test
  fun `should get required task result`() {
    val result = Tasks
        .forResult(42)
        .asRequired()

    assertThat(result).isEqualTo(42)
  }

  @Test(expected = IllegalStateException::class)
  fun `should throw illegal state exception for empty required result`() {
    Tasks
        .forResult<Int>(null)
        .asRequired()
  }

  @Test
  fun `should get task result`() {
    val result = Tasks
        .forResult(42)
        .asResult()

    assertThat(result).isEqualTo(42)
  }

  @Test
  fun `should get nullable task result`() {
    val result = Tasks
        .forResult<Int>(null)
        .asResult()

    assertThat(result).isNull()
  }

  @Test(expected = RuntimeException::class)
  fun `should throw task exception`() {
    Tasks
        .forException<Int>(RuntimeException())
        .asResult()
  }

  @Test(expected = CancellationException::class)
  fun `should throw cancellation exception on cancelled task`() {
    Tasks
        .forCanceled<Int>()
        .asResult()
  }

  @Test(expected = IllegalStateException::class)
  fun `should throw illegal state exception on incomplete task`() {
    mock<Task<Int>>()
        .asResult()
  }
}
