package io.ashdavies.rx.rxtasks

import android.os.Handler
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.then
import org.junit.Test

internal class MainThreadExecutorTest {

  private val handler = mock<Handler>()
  private val command = mock<Runnable>()

  private val executor = MainThreadExecutor(handler)

  @Test
  fun `should post command with handler`() {
    executor.execute(command)

    then(handler).should().post(command)
  }
}
