package io.ashdavies.rx.rxtasks.internal

import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import io.reactivex.SingleEmitter

internal class SingleEmitterListener<T>(private val emitter: SingleEmitter<T>) : OnCompleteListener<T> {
  override fun onComplete(task: Task<T>) =
      if (task.isSuccessful) emitter.onSuccess(task.result)
      else emitter.onError(task.exception ?: NullPointerException("Task failed with no exception"))
}
