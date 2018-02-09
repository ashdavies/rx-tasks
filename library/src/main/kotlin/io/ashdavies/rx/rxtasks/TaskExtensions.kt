// for single function call, inlining is just fine
@file:Suppress("NOTHING_TO_INLINE")

package io.ashdavies.rx.rxtasks

import com.google.android.gms.tasks.Task

inline fun Task<Void>.toCompletable() = RxTasks.completable(this)

inline fun <T> Task<T>.toSingle() = RxTasks.single(this)
