package io.ashdavies.rx.rxtasks.internal

import com.google.android.gms.tasks.OnCompleteListener
import io.reactivex.SingleEmitter

internal class SingleTaskListenerFactory<Result> : TaskListenerFactory<Result, SingleEmitter<Result>> {
  override fun createOnCompleteListener(emitter: SingleEmitter<Result>): OnCompleteListener<Result> = SingleEmitterListener(emitter)
}
