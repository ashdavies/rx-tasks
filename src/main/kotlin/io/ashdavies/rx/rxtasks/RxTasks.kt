@file:JvmName("RxTasks")

package io.ashdavies.rx.rxtasks

import com.google.android.gms.tasks.Task

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Deprecated(
    message = "Use Task<Void>.toCompletable() instead",
    replaceWith = ReplaceWith(
        expression = "task.toCompletable()",
        imports = ["io.ashdavies.rx.rxtasks.toCompletable"]
    )
)
fun completable(task: Task<Void>): Completable = task.toCompletable()

@Deprecated(
    message = "Use Task<T>.toSingle() instead",
    replaceWith = ReplaceWith(
        expression = "task.toSingle()",
        imports = ["io.ashdavies.rx.rxtasks.toSingle"]
    )
)
fun <T : Any> single(task: Task<T>): Single<T> = task.toSingle()
