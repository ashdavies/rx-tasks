package io.ashdavies.rx.rxtasks

import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.android.gms.tasks.Task
import io.reactivex.CompletableEmitter
import io.reactivex.CompletableOnSubscribe
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.BDDMockito.then
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
internal class CompletableTaskOnSubscribeTest {

  private lateinit var onSubscribe: CompletableOnSubscribe

  @Mock private lateinit var task: Task<Void>
  @Mock private lateinit var emitter: CompletableEmitter

  @Mock private lateinit var factory: TaskListenerFactory<Void, CompletableEmitter>
  @Mock private lateinit var onSuccessListener: OnSuccessListener<Void>
  @Mock private lateinit var onFailureListener: OnFailureListener

  @Before
  fun `set up`() {
    onSubscribe = CompletableTaskOnSubscribe(task, factory)
  }

  @Test
  fun `should subscribe with on success listener`() {
    given(factory.createOnSuccessListener(emitter)).willReturn(onSuccessListener)

    onSubscribe.subscribe(emitter)

    then(factory).should().createOnSuccessListener(emitter)
    then(task).should().addOnSuccessListener(onSuccessListener)
  }

  @Test
  fun `should subscribe with on failure listener`() {
    given(factory.createOnFailureListener(emitter)).willReturn(onFailureListener)

    onSubscribe.subscribe(emitter)

    then(factory).should().createOnFailureListener(emitter)
    then(task).should().addOnFailureListener(onFailureListener)
  }
}
