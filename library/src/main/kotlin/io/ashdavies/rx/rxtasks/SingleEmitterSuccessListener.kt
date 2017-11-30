package io.ashdavies.rx.rxtasks

import com.google.android.gms.tasks.OnSuccessListener
import io.reactivex.SingleEmitter

internal class SingleEmitterSuccessListener<T>(private val emitter: SingleEmitter<T>) : OnSuccessListener<T> {

  override fun onSuccess(t: T?) {
    if (t == null) {
      emitter.onError(NullPointerException())
      return
    }

    emitter.onSuccess(t)
  }
}
