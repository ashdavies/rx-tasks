package io.ashdavies.rx.rxtasks

import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import io.ashdavies.rx.rxtasks.internal.CompletableTaskOnSubscribe
import io.ashdavies.rx.rxtasks.internal.TaskListenerFactory
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
  @Mock private lateinit var onCompleteListener: OnCompleteListener<Void>

  @Before
  fun `set up`() {
    onSubscribe = CompletableTaskOnSubscribe(task, factory)
  }

  @Test
  fun `should subscribe with listener`() {
    given(factory.createOnCompleteListener(emitter)).willReturn(onCompleteListener)

    onSubscribe.subscribe(emitter)

    then(factory).should().createOnCompleteListener(emitter)
    then(task).should().addOnCompleteListener(onCompleteListener)
  }
}
