package io.ashdavies.rx.rxtasks

import com.google.android.gms.tasks.Task
import io.reactivex.Completable
import io.reactivex.Single

object RxTasks {

  @JvmStatic
  @Deprecated(
      message = "Use Task<Void>.toCompletable() instead",
      replaceWith = ReplaceWith(
          expression = "task.toCompletable()",
          imports = ["io.ashdavies.rx.rxtasks.toCompletable"]
      )
  )
  fun completable(task: Task<Void>): Completable = task.toCompletable()

  @JvmStatic
  @Deprecated(
      message = "Use Task<T>.toSingle() instead",
      replaceWith = ReplaceWith(
          expression = "task.toSingle()",
          imports = ["io.ashdavies.rx.rxtasks.toSingle"]
      )
  )
  fun <T> single(task: Task<T>): Single<T> = task.toSingle()
}
