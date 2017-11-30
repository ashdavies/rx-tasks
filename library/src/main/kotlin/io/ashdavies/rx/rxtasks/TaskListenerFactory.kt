package io.ashdavies.rx.rxtasks

import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener

internal interface TaskListenerFactory<Result, in Emitter> {

  fun createOnSuccessListener(emitter: Emitter): OnSuccessListener<Result>

  fun createOnFailureListener(emitter: Emitter): OnFailureListener
}
