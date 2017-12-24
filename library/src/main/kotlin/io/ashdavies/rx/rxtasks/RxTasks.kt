package io.ashdavies.rx.rxtasks

import com.google.android.gms.tasks.Task

object RxTasks {

  fun completable(task: Task<Void>) = task.toCompletable()

  fun <T> single(task: Task<T>) = task.toSingle()
}
