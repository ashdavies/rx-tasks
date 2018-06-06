package io.ashdavies.rx.rxtasks

import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.android.gms.tasks.Task
import com.nhaarman.mockito_kotlin.argumentCaptor
import com.nhaarman.mockito_kotlin.eq
import com.nhaarman.mockito_kotlin.given
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.then
import io.reactivex.SingleEmitter
import org.junit.Test
import java.util.concurrent.Executor

internal class SingleTaskOnSubscribeTest {

  private val task = mock<Task<Boolean>>()
  private val emitter = mock<SingleEmitter<Boolean>>()
  private val executor = mock<Executor>()

  private val single = SingleTaskOnSubscribe(task, executor)

  @Test
  fun `should add on success listener`() {
    val captor = argumentCaptor<OnSuccessListener<Boolean>>()
    given(task.addOnSuccessListener(eq(executor), captor.capture())).willReturn(task)

    single.subscribe(emitter)
    captor.lastValue.onSuccess(true)

    then(emitter).should().onSuccess(true)
  }

  @Test
  fun `should add on failure listener`() {
    val captor = argumentCaptor<OnFailureListener>()
    given(task.addOnFailureListener(eq(executor), captor.capture())).willReturn(task)

    val exception = RuntimeException()
    single.subscribe(emitter)

    captor.lastValue.onFailure(exception)
    then(emitter).should().onError(exception)
  }
}
