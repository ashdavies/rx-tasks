package io.ashdavies.rx.rxtasks

import com.google.android.gms.tasks.Task
import io.reactivex.CompletableEmitter
import io.reactivex.CompletableOnSubscribe

internal class CompletableTaskOnSubscribe(
    task: Task<Void>, factory: TaskListenerFactory<Void, CompletableEmitter>
) : TaskOnSubscribe<Void, CompletableEmitter>(task, factory), CompletableOnSubscribe
