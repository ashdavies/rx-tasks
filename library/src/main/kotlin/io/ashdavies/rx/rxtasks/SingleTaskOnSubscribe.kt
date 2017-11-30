package io.ashdavies.rx.rxtasks

import com.google.android.gms.tasks.Task
import io.reactivex.SingleEmitter
import io.reactivex.SingleOnSubscribe

internal class SingleTaskOnSubscribe<Result> @JvmOverloads constructor(
    task: Task<Result>, factory: TaskListenerFactory<Result, SingleEmitter<Result>> = SingleTaskListenerFactory()
) : TaskOnSubscribe<Result, SingleEmitter<Result>>(task, factory), SingleOnSubscribe<Result>
