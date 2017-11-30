package io.ashdavies.rx.rxtasks

import com.google.android.gms.tasks.Task

internal abstract class TaskOnSubscribe<Result, in Emitter>(private val task: Task<Result>, private val factory: TaskListenerFactory<Result, Emitter>) {

  fun subscribe(emitter: Emitter) {
    task.addOnSuccessListener(factory.createOnSuccessListener(emitter))
    task.addOnFailureListener(factory.createOnFailureListener(emitter))
  }
}
