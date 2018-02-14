package io.ashdavies.rx.rxtasks

import com.google.android.gms.tasks.Task
import java.util.concurrent.Executor

internal abstract class TaskOnSubscribe<T, in E>(private val task: Task<T>, private val factory: TaskListenerFactory<T, E>) {

  fun subscribe(emitter: E) {
    val scheduler = factory.scheduler
    if (scheduler == null) {
      task.addOnSuccessListener(factory.createOnSuccessListener(emitter))
      task.addOnFailureListener(factory.createOnFailureListener(emitter))
    } else {
      val executor = Executor { scheduler.scheduleDirect(it) }
      task.addOnSuccessListener(executor, factory.createOnSuccessListener(emitter))
      task.addOnFailureListener(executor, factory.createOnFailureListener(emitter))
    }
  }
}
