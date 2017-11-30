package io.ashdavies.rx.rxtasks

import com.google.android.gms.tasks.OnSuccessListener
import com.google.android.gms.tasks.Task
import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockito_kotlin.argumentCaptor
import com.nhaarman.mockito_kotlin.then
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
    val captor = argumentCaptor<OnSuccessListener<Void>>()

    RxTasks.completable(task).subscribe()

    then(task).should().addOnSuccessListener(captor.capture())
    assertThat(captor.lastValue).isInstanceOf(CompletableEmitterSuccessListener::class.java)
  }

  @Test
  fun `should create single task`() {
    val captor = argumentCaptor<OnSuccessListener<Void>>()

    RxTasks.completable(task).subscribe()

    then(task).should().addOnSuccessListener(captor.capture())
    assertThat(captor.lastValue).isInstanceOf(CompletableEmitterSuccessListener::class.java)
  }
}
