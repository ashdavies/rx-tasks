package io.ashdavies.rx.rxtasks

import com.google.android.gms.tasks.Task
import io.reactivex.Completable
import io.reactivex.Single

class RxTasks private constructor() {

  companion object {

    fun completable(task: Task<Void>): Completable {
      return Completable.create(CompletableTaskOnSubscribe(task))
    }

    fun <T> single(task: Task<T>): Single<T> {
      return Single.create(SingleTaskOnSubscribe(task))
    }
  }
}
