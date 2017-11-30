package io.ashdavies.rx.rxtasks

import io.reactivex.SingleEmitter

internal class SingleTaskListenerFactory<Result> : TaskListenerFactory<Result, SingleEmitter<Result>> {

  override fun createOnSuccessListener(emitter: SingleEmitter<Result>) = SingleEmitterSuccessListener(emitter)

  override fun createOnFailureListener(emitter: SingleEmitter<Result>) = SingleEmitterFailureListener(emitter)
}
