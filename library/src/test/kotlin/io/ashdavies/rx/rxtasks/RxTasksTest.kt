package io.ashdavies.rx.rxtasks

import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockito_kotlin.argumentCaptor
import com.nhaarman.mockito_kotlin.then
import io.ashdavies.rx.rxtasks.internal.CompletableEmitterListener
import io.ashdavies.rx.rxtasks.internal.SingleEmitterListener
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import java.lang.reflect.Constructor

@RunWith(MockitoJUnitRunner::class)
internal class RxTasksTest {

  private lateinit var constructor: Constructor<RxTasks>

  @Mock private lateinit var task: Task<Void>

  @Before
  fun `set up`() {
    constructor = RxTasks::class.java.getDeclaredConstructor()
  }

  @Test
  fun `should create completable task`() {
    val captor = argumentCaptor<OnCompleteListener<Void>>()

    RxTasks.completable(task).subscribe()

    then(task).should().addOnCompleteListener(captor.capture())
    assertThat(captor.lastValue).isInstanceOf(CompletableEmitterListener::class.java)
  }

  @Test
  fun `should create single task`() {
    val captor = argumentCaptor<OnCompleteListener<Void>>()

    RxTasks.single(task).subscribe()

    then(task).should().addOnCompleteListener(captor.capture())
    assertThat(captor.lastValue).isInstanceOf(SingleEmitterListener::class.java)
  }

  @Test
  fun `should create completable task with extension`() {
    val captor = argumentCaptor<OnCompleteListener<Void>>()

    task.toCompletable().subscribe()

    then(task).should().addOnCompleteListener(captor.capture())
    assertThat(captor.lastValue).isInstanceOf(CompletableEmitterListener::class.java)
  }

  @Test
  fun `should create single task with extension`() {
    val captor = argumentCaptor<OnCompleteListener<Void>>()

    task.toSingle().subscribe()

    then(task).should().addOnCompleteListener(captor.capture())
    assertThat(captor.lastValue).isInstanceOf(SingleEmitterListener::class.java)
  }
}
