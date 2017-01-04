package io.ashdavies.rxtasks;

import com.google.android.gms.tasks.Task;

abstract class TaskOnSubscribe<Result, Emitter> {

  private final Task<Result> task;
  private final TaskListenerFactory<Result, Emitter> factory;

  TaskOnSubscribe(Task<Result> task, TaskListenerFactory<Result, Emitter> factory) {
    this.task = task;
    this.factory = factory;
  }

  public void subscribe(Emitter emitter) {
    task.addOnSuccessListener(factory.createOnSuccessListener(emitter));
    task.addOnFailureListener(factory.createOnFailureListener(emitter));
  }
}
