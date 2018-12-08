package io.ashdavies.rx.rxtasks

import com.google.android.gms.tasks.Task
import java.util.concurrent.CancellationException

internal fun <T : Any> Task<T>.asRequired(): T = asResult() ?: throw IllegalStateException("Task $this returned empty result")

internal fun <T : Any> Task<T>.asResult(): T? = if (isComplete) {
  if (!isCanceled) exception
      ?.let { throw it }
      ?: result
  else throw CancellationException("Task $this was cancelled normally")
} else throw IllegalStateException("Task $this not complete")
