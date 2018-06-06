package io.ashdavies.rx.rxtasks

import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.android.gms.tasks.Task
import io.reactivex.CompletableEmitter
import io.reactivex.CompletableOnSubscribe
import java.util.concurrent.Executor

internal class CompletableTaskOnSubscribe(private val task: Task<Void>, private val executor: Executor) : CompletableOnSubscribe {

  override fun subscribe(emitter: CompletableEmitter) {
    task.addOnSuccessListener(executor, OnSuccessListener { emitter.onComplete() })
    task.addOnFailureListener(executor, OnFailureListener { emitter.onError(it) })
  }
}
