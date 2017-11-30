package io.ashdavies.rx.rxtasks

import com.google.android.gms.tasks.OnFailureListener
import io.reactivex.SingleEmitter

internal class SingleEmitterFailureListener<T>(private val emitter: SingleEmitter<T>) : OnFailureListener {

  override fun onFailure(exception: Exception) = emitter.onError(exception)
}
