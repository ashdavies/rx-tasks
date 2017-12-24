package io.ashdavies.rx.rxtasks

import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.android.gms.tasks.Task
import com.nhaarman.mockito_kotlin.given
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.then
import io.reactivex.SingleEmitter
import org.junit.Test

class SingleTaskOnSubscribeTest {

  private val task = mock<Task<Any>>()
  private val emitter = mock<SingleEmitter<Any>>()
  private val factory = mock<TaskListenerFactory<Any, SingleEmitter<Any>>>()
  private val success = mock<OnSuccessListener<Any>>()
  private val failure = mock<OnFailureListener>()

  private val subscribe = SingleTaskOnSubscribe(task, factory)

  @Test
  fun `should subscribe with on success listener`() {
    given(factory.createOnSuccessListener(emitter)).willReturn(success)

    subscribe.subscribe(emitter)

    then(factory).should().createOnSuccessListener(emitter)
    then(task).should().addOnSuccessListener(success)
  }

  @Test
  fun `should subscribe with on failure listener`() {
    given(factory.createOnFailureListener(emitter)).willReturn(failure)

    subscribe.subscribe(emitter)

    then(factory).should().createOnFailureListener(emitter)
    then(task).should().addOnFailureListener(failure)
  }
}
