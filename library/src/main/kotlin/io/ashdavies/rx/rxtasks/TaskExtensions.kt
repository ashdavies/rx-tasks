package io.ashdavies.rx.rxtasks

import com.google.android.gms.tasks.Task
import io.reactivex.Completable
import io.reactivex.Scheduler
import io.reactivex.Single

fun Task<Void>.toCompletable(): Completable = Completable.create(CompletableTaskOnSubscribe(this))
fun Task<Void>.toCompletable(scheduler: Scheduler): Completable =
  Completable.create(CompletableTaskOnSubscribe(this, CompletableTaskListenerFactory(scheduler)))

fun <T> Task<T>.toSingle(): Single<T> = Single.create(SingleTaskOnSubscribe(this))
fun <T> Task<T>.toSingle(scheduler: Scheduler): Single<T> = Single.create(SingleTaskOnSubscribe(this, SingleTaskListenerFactory(scheduler)))
