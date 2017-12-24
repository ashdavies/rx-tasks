package io.ashdavies.rx.rxtasks

import com.google.android.gms.tasks.Task

internal abstract class TaskOnSubscribe<T, in E>(private val task: Task<T>, private val factory: TaskListenerFactory<T, E>) {

  fun subscribe(emitter: E) {
    task.addOnSuccessListener(factory.createOnSuccessListener(emitter))
    task.addOnFailureListener(factory.createOnFailureListener(emitter))
  }
}
