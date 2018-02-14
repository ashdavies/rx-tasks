package io.ashdavies.rx.rxtasks

import com.google.android.gms.tasks.Task
import io.reactivex.Scheduler

object RxTasks {

  fun completable(task: Task<Void>) = task.toCompletable()
  fun completable(task: Task<Void>, scheduler: Scheduler) = task.toCompletable(scheduler)

  fun <T> single(task: Task<T>) = task.toSingle()
  fun <T> single(task: Task<T>, scheduler: Scheduler) = task.toSingle(scheduler)
}
