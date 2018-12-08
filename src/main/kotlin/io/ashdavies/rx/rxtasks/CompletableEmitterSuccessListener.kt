package io.ashdavies.rx.rxtasks

import com.google.android.gms.tasks.OnSuccessListener
import io.reactivex.CompletableEmitter

internal class CompletableEmitterSuccessListener(private val emitter: CompletableEmitter) : OnSuccessListener<Void> {

  override fun onSuccess(void: Void) = emitter.onComplete()
}
