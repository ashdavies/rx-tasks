package io.ashdavies.rx.rxtasks

import io.reactivex.SingleEmitter

internal class SingleTaskListenerFactory<T> : TaskListenerFactory<T, SingleEmitter<T>> {

  override fun createOnSuccessListener(emitter: SingleEmitter<T>) = SingleEmitterSuccessListener(emitter)

  override fun createOnFailureListener(emitter: SingleEmitter<T>) = SingleEmitterFailureListener(emitter)
}
