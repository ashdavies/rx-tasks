package io.ashdavies.rx.rxtasks

import com.google.android.gms.tasks.Task
import io.reactivex.SingleEmitter
import io.reactivex.SingleOnSubscribe

internal class SingleTaskOnSubscribe<T>(
    task: Task<T>, factory: TaskListenerFactory<T, SingleEmitter<T>> = SingleTaskListenerFactory()
) : TaskOnSubscribe<T, SingleEmitter<T>>(task, factory), SingleOnSubscribe<T>
