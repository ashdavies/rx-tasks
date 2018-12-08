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

internal class CompletableTaskTest {

  @Test
  fun `should represent void as result`() {
    Tasks
        .forResult<Void>(null)
        .toCompletable()
        .test()
        .assertResult()
  }

  @Test
  fun `should represent cancelled as error`() {
    Tasks
        .forCanceled<Void>()
        .toCompletable()
        .test()
        .assertError(CancellationException::class.java)
  }

  @Test
  fun `should represent exception as error`() {
    val exception = RuntimeException()

    Tasks
        .forException<Void>(exception)
        .toCompletable()
        .test()
        .assertError(exception)
  }

  @Test
  fun `should add on complete listener`() {
    val task = mock<Task<Void>>()

    task
        .toCompletable()
        .subscribe()

    then(task)
        .should()
        .addOnCompleteListener(any<CompletableEmitterListener>())
  }

  @Test
  fun `should execute on provided executor`() {
    val executor = mock<Executor>()
    val task = mock<Task<Void>>()

    task
        .toCompletable(executor)
        .subscribe()

    then(task)
        .should()
        .addOnCompleteListener(eq(executor), any<CompletableEmitterListener>())
  }

  @Test
  fun `should execute with provided activity`() {
    val activity = mock<Activity>()
    val task = mock<Task<Void>>()

    task
        .toCompletable(activity)
        .subscribe()

    then(task)
        .should()
        .addOnCompleteListener(eq(activity), any<CompletableEmitterListener>())
  }
}
