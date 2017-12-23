package io.ashdavies.rx.rxtasks.internal

import com.google.android.gms.tasks.OnCompleteListener

internal interface TaskListenerFactory<Result, in Emitter> {
  fun createOnCompleteListener(emitter: Emitter): OnCompleteListener<Result>
}
