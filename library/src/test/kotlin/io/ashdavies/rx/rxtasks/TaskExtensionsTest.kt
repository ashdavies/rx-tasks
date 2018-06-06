package io.ashdavies.rx.rxtasks

import com.google.android.gms.tasks.Task
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.eq
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.then
import org.junit.Test
import java.util.concurrent.Executor

internal class TaskExtensionsTest {

  private val executor = mock<Executor>()

  @Test
  fun `should execute completable with provided executor`() {
    val task = mock<Task<Void>>()

    task.toCompletable(executor).test()

    then(task).should().addOnSuccessListener(eq(executor), any())
    then(task).should().addOnFailureListener(eq(executor), any())
  }

  @Test
  fun `should execute single with provided executor`() {
    val task = mock<Task<Boolean>>()

    task.toSingle(executor).test()

    then(task).should().addOnSuccessListener(eq(executor), any())
    then(task).should().addOnFailureListener(eq(executor), any())
  }
}
