package io.ashdavies.rx.rxtasks

import com.google.android.gms.tasks.Task
import io.reactivex.Completable
import io.reactivex.Single
import java.util.concurrent.Executor

fun Task<Void>.toCompletable(executor: Executor = MainThreadExecutor()): Completable = Completable.create(CompletableTaskOnSubscribe(this, executor))

fun <T> Task<T>.toSingle(executor: Executor = MainThreadExecutor()): Single<T> = Single.create(SingleTaskOnSubscribe(this, executor))
