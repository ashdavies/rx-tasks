package io.ashdavies.rx.rxtasks

import com.google.android.gms.tasks.Task
import io.reactivex.Completable
import io.reactivex.Single

fun Task<Void>.toCompletable(): Completable = RxTasks.completable(this)

fun <T> Task<T>.toSingle(): Single<T> = RxTasks.single(this)
