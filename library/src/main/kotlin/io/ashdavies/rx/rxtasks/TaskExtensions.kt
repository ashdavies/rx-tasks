package io.ashdavies.rx.rxtasks

import com.google.android.gms.tasks.Task
import io.reactivex.Completable
import io.reactivex.Single

fun Task<Void>.toCompletable(): Completable = Completable.create(CompletableTaskOnSubscribe(this, CompletableTaskListenerFactory()))

fun <T> Task<T>.toSingle(): Single<T> = Single.create(SingleTaskOnSubscribe(this, SingleTaskListenerFactory()))
