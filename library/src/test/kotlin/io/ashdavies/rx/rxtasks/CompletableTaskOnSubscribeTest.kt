package io.ashdavies.rx.rxtasks

import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.android.gms.tasks.Task
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.willReturn
import io.reactivex.CompletableEmitter
import org.junit.Test
import org.mockito.BDDMockito.given
import org.mockito.BDDMockito.then

internal class CompletableTaskOnSubscribeTest {

  private val task = mock<Task<Void>>()
  private val emitter = mock<CompletableEmitter>()
  private val factory = mock<TaskListenerFactory<Void, CompletableEmitter>>()
  private val success = mock<OnSuccessListener<Void>>()
  private val failure = mock<OnFailureListener>()

  private val subscribe = CompletableTaskOnSubscribe(task, factory)

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
