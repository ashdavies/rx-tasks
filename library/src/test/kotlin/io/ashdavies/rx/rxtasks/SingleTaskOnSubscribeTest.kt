package io.ashdavies.rx.rxtasks

import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.nhaarman.mockito_kotlin.given
import com.nhaarman.mockito_kotlin.then
import io.ashdavies.rx.rxtasks.internal.SingleTaskOnSubscribe
import io.ashdavies.rx.rxtasks.internal.TaskListenerFactory
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
  @Mock private lateinit var onCompleteListener: OnCompleteListener<String>

  @Before
  fun `set up`() {
    onSubscribe = SingleTaskOnSubscribe(task, factory)
  }

  @Test
  fun `should subscribe with listener`() {
    given(factory.createOnCompleteListener(emitter)).willReturn(onCompleteListener)

    onSubscribe.subscribe(emitter)

    then(factory).should().createOnCompleteListener(emitter)
    then(task).should().addOnCompleteListener(onCompleteListener)
  }
}
