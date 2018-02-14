package io.ashdavies.rx.rxtasks

import io.reactivex.Scheduler
import io.reactivex.SingleEmitter

internal class SingleTaskListenerFactory<T> constructor(override val scheduler: Scheduler? = null) : TaskListenerFactory<T, SingleEmitter<T>> {

  override fun createOnSuccessListener(emitter: SingleEmitter<T>) = SingleEmitterSuccessListener(emitter)

  override fun createOnFailureListener(emitter: SingleEmitter<T>) = SingleEmitterFailureListener(emitter)
}
