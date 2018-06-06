package io.ashdavies.rx.rxtasks

import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.android.gms.tasks.Task
import com.nhaarman.mockito_kotlin.argumentCaptor
import com.nhaarman.mockito_kotlin.eq
import com.nhaarman.mockito_kotlin.given
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.then
import io.reactivex.CompletableEmitter
import org.junit.Test
import java.util.concurrent.Executor

internal class CompletableTaskOnSubscribeTest {

  private val task = mock<Task<Void>>()
  private val emitter = mock<CompletableEmitter>()
  private val executor = mock<Executor>()

  private val completable = CompletableTaskOnSubscribe(task, executor)

  @Test
  fun `should add on success listener`() {
    val captor = argumentCaptor<OnSuccessListener<Void>>()
    given(task.addOnSuccessListener(eq(executor), captor.capture())).willReturn(task)

    completable.subscribe(emitter)
    captor.lastValue.onSuccess(null)

    then(emitter).should().onComplete()
  }

  @Test
  fun `should add on failure listener`() {
    val captor = argumentCaptor<OnFailureListener>()
    given(task.addOnFailureListener(eq(executor), captor.capture())).willReturn(task)

    val exception = RuntimeException()
    completable.subscribe(emitter)

    captor.lastValue.onFailure(exception)
    then(emitter).should().onError(exception)
  }
}
