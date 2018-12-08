package io.ashdavies.rx.rxtasks

import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import io.reactivex.CompletableEmitter

internal class CompletableEmitterListener(private val emitter: CompletableEmitter) : OnCompleteListener<Void> {
  override fun onComplete(task: Task<Void>) = try {
    task.asResult()
    emitter.onComplete()
  } catch (exception: Exception) {
    emitter.onError(exception)
  }
}
