package io.ashdavies.rx.rxtasks

import com.google.android.gms.tasks.Task
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.then
import org.junit.Ignore
import org.junit.Test
import java.util.concurrent.Executor

internal class RxTasksTest {

  private val executor = mock<Executor>()

  @Test
  fun `should delegate to completable extension`() {
    val task = mock<Task<Void>>()

    RxTasks.completable(task, executor)

    then(task).should().toCompletable(executor)
  }

  @Test
  @Ignore
  fun `should delegate to single extension`() {
    val task = mock<Task<Boolean>>()

    RxTasks.single(task, executor)

    then(task).should().toSingle(executor)
  }
}
