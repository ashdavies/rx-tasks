package io.ashdavies.rx.rxtasks

import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.android.gms.tasks.Task
import com.nhaarman.mockito_kotlin.given
import com.nhaarman.mockito_kotlin.then
import io.reactivex.SingleEmitter
import io.reactivex.SingleOnSubscribe
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SingleTaskOnSubscribeTest {

  private lateinit var onSubscribe: SingleOnSubscribe<String>

  @Mock private lateinit var task: Task<String>
  @Mock private lateinit var emitter: SingleEmitter<String>

  @Mock private lateinit var factory: TaskListenerFactory<String, SingleEmitter<String>>
  @Mock private lateinit var onSuccessListener: OnSuccessListener<String>
  @Mock private lateinit var onFailureListener: OnFailureListener

  @Before
  fun `set up`() {
    onSubscribe = SingleTaskOnSubscribe(task, factory)
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
