package io.ashdavies.rx.rxtasks

import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.android.gms.tasks.Task
import io.reactivex.SingleEmitter
import io.reactivex.SingleOnSubscribe
import java.util.concurrent.Executor

internal class SingleTaskOnSubscribe<T>(private val task: Task<T>, private val executor: Executor) : SingleOnSubscribe<T> {

  override fun subscribe(emitter: SingleEmitter<T>) {
    task.addOnSuccessListener(executor, OnSuccessListener { emitter.onSuccess(it) })
    task.addOnFailureListener(executor, OnFailureListener { emitter.onError(it) })
  }
}
