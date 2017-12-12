package io.ashdavies.rx.rxtasks.internal

import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import io.reactivex.CompletableEmitter

internal class CompletableEmitterListener(private val emitter: CompletableEmitter) : OnCompleteListener<Void> {
  override fun onComplete(task: Task<Void>) =
      if (task.isSuccessful) emitter.onComplete()
      else emitter.onError(task.exception ?: NullPointerException("Task failed with no exception"))
}
