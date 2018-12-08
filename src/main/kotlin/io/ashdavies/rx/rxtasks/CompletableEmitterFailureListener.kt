package io.ashdavies.rx.rxtasks

import com.google.android.gms.tasks.OnFailureListener
import io.reactivex.CompletableEmitter

internal class CompletableEmitterFailureListener(private val emitter: CompletableEmitter) : OnFailureListener {

  override fun onFailure(exception: Exception) = emitter.onError(exception)
}
