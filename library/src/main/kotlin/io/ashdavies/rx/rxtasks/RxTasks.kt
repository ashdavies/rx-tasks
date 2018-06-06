package io.ashdavies.rx.rxtasks

import com.google.android.gms.tasks.Task
import io.reactivex.Completable
import io.reactivex.Single
import java.util.concurrent.Executor

object RxTasks {

  @JvmStatic
  @JvmOverloads
  @Deprecated(
      message = "Use Task<Void>.toCompletable() instead",
      replaceWith = ReplaceWith(
          expression = "task.toCompletable()",
          imports = ["io.ashdavies.rx.rxtasks.toCompletable"]
      )
  )
  fun completable(task: Task<Void>, executor: Executor = MainThreadExecutor()): Completable = task.toCompletable(executor)

  @JvmStatic
  @JvmOverloads
  @Deprecated(
      message = "Use Task<T>.toSingle() instead",
      replaceWith = ReplaceWith(
          expression = "task.toSingle()",
          imports = ["io.ashdavies.rx.rxtasks.toSingle"]
      )
  )
  fun <T> single(task: Task<T>, executor: Executor = MainThreadExecutor()): Single<T> = task.toSingle(executor)
}
