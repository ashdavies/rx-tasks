package io.ashdavies.rx.rxtasks.internal

import com.google.android.gms.tasks.Task

internal abstract class TaskOnSubscribe<Result, in Emitter>(private val task: Task<Result>, private val factory: TaskListenerFactory<Result, Emitter>) {
  fun subscribe(emitter: Emitter) {
    task.addOnCompleteListener(factory.createOnCompleteListener(emitter))
  }
}
