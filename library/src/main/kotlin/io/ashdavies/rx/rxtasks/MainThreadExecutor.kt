package io.ashdavies.rx.rxtasks

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor

internal class MainThreadExecutor(private val handler: Handler) : Executor {

  constructor() : this(Handler(Looper.getMainLooper()))

  override fun execute(command: Runnable) {
    handler.post(command)
  }
}
