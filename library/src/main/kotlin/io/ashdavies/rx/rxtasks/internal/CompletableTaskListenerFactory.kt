package io.ashdavies.rx.rxtasks.internal

import com.google.android.gms.tasks.OnCompleteListener
import io.reactivex.CompletableEmitter

internal class CompletableTaskListenerFactory : TaskListenerFactory<Void, CompletableEmitter> {
  override fun createOnCompleteListener(emitter: CompletableEmitter): OnCompleteListener<Void> = CompletableEmitterListener(emitter)
}
