package io.ashdavies.rx.rxtasks

import io.reactivex.CompletableEmitter
import io.reactivex.Scheduler

internal class CompletableTaskListenerFactory constructor(override val scheduler: Scheduler? = null) : TaskListenerFactory<Void, CompletableEmitter> {

  override fun createOnSuccessListener(emitter: CompletableEmitter) = CompletableEmitterSuccessListener(emitter)

  override fun createOnFailureListener(emitter: CompletableEmitter) = CompletableEmitterFailureListener(emitter)
}
