package io.ashdavies.rx.rxtasks

import android.app.Activity
import com.google.android.gms.tasks.Task
import com.google.android.gms.tasks.Tasks
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.eq
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.then
import org.junit.Test
import java.util.concurrent.CancellationException
import java.util.concurrent.Executor

internal class SingleTaskTest {

  @Test
  fun `should represent value as result`() {
    Tasks
        .forResult(42)
        .toSingle()
        .test()
        .assertResult(42)
  }

  @Test
  fun `should represent null as error`() {
    Tasks
        .forResult<Int>(null)
        .toSingle()
        .test()
        .assertError(IllegalStateException::class.java)
  }

  @Test
  fun `should represent cancelled as error`() {
    Tasks
        .forCanceled<Int>()
        .toSingle()
        .test()
        .assertError(CancellationException::class.java)
  }

  @Test
  fun `should represent exception as error`() {
    val exception = RuntimeException()

    Tasks
        .forException<Int>(exception)
        .toSingle()
        .test()
        .assertError(exception)
  }

  @Test
  fun `should add on complete listener`() {
    val task = mock<Task<Int>>()

    task
        .toSingle()
        .subscribe()

    then(task)
        .should()
        .addOnCompleteListener(any<SingleEmitterListener<Int>>())
  }

  @Test
  fun `should execute on provided executor`() {
    val executor = mock<Executor>()
    val task = mock<Task<Int>>()

    task
        .toSingle(executor)
        .subscribe()

    then(task)
        .should()
        .addOnCompleteListener(eq(executor), any<SingleEmitterListener<Int>>())
  }

  @Test
  fun `should execute with provided activity`() {
    val activity = mock<Activity>()
    val task = mock<Task<Int>>()

    task
        .toSingle(activity)
        .subscribe()

    then(task)
        .should()
        .addOnCompleteListener(eq(activity), any<SingleEmitterListener<Int>>())
  }
}
