package io.ashdavies.rx.rxtasks

import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import io.reactivex.Scheduler

internal interface TaskListenerFactory<T, in E> {

  fun createOnSuccessListener(emitter: E): OnSuccessListener<T>

  fun createOnFailureListener(emitter: E): OnFailureListener

  /** optional scheduler to use for receiving results. if null, main thread will be used. */
  val scheduler: Scheduler?
}
