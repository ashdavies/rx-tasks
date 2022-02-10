package io.ashdavies.rx.rxtasks

import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import io.reactivex.rxjava3.core.SingleEmitter

internal class SingleEmitterListener<T : Any>(private val emitter: SingleEmitter<T>) : OnCompleteListener<T> {
  override fun onComplete(task: Task<T>) = try {
    emitter.onSuccess(task.asRequired())
  } catch (exception: Exception) {
    emitter.onError(exception)
  }
}
