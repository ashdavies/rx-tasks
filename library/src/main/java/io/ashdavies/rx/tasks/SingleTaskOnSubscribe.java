package io.ashdavies.rx.tasks;

import com.google.android.gms.tasks.Task;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;

class SingleTaskOnSubscribe<Result> extends TaskOnSubscribe<Result, SingleEmitter<Result>> implements SingleOnSubscribe<Result> {

  SingleTaskOnSubscribe(Task<Result> task) {
    this(task, new SingleTaskListenerFactory<Result>());
  }

  SingleTaskOnSubscribe(Task<Result> task, TaskListenerFactory<Result, SingleEmitter<Result>> factory) {
    super(task, factory);
  }
}
