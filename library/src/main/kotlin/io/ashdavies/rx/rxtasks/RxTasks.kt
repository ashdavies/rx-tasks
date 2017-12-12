package io.ashdavies.rx.rxtasks

import com.google.android.gms.tasks.Task
import io.ashdavies.rx.rxtasks.internal.CompletableTaskOnSubscribe
import io.ashdavies.rx.rxtasks.internal.SingleTaskOnSubscribe
import io.reactivex.Completable
import io.reactivex.Single

object RxTasks {
  fun completable(task: Task<Void>): Completable = Completable.create(CompletableTaskOnSubscribe(task))

  fun <T> single(task: Task<T>): Single<T> = Single.create(SingleTaskOnSubscribe(task))
}
