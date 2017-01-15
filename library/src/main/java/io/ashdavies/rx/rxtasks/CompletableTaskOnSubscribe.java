package io.ashdavies.rx.rxtasks;

import com.google.android.gms.tasks.Task;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableOnSubscribe;

class CompletableTaskOnSubscribe extends TaskOnSubscribe<Void, CompletableEmitter> implements CompletableOnSubscribe {

  CompletableTaskOnSubscribe(Task<Void> task) {
    this(task, new CompletableTaskListenerFactory());
  }

  CompletableTaskOnSubscribe(Task<Void> task, TaskListenerFactory<Void, CompletableEmitter> factory) {
    super(task, factory);
  }
}
