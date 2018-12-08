package io.ashdavies.rx.rxtasks

import io.reactivex.CompletableEmitter

internal class CompletableTaskListenerFactory : TaskListenerFactory<Void, CompletableEmitter> {

  override fun createOnSuccessListener(emitter: CompletableEmitter) = CompletableEmitterSuccessListener(emitter)

  override fun createOnFailureListener(emitter: CompletableEmitter)= CompletableEmitterFailureListener(emitter)
}
