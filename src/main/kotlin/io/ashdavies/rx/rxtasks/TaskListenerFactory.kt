package io.ashdavies.rx.rxtasks

import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener

internal interface TaskListenerFactory<T, in E> {

  fun createOnSuccessListener(emitter: E): OnSuccessListener<T>

  fun createOnFailureListener(emitter: E): OnFailureListener
}
