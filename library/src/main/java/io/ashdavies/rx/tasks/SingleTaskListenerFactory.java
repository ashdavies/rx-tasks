package io.ashdavies.rx.tasks;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import io.reactivex.SingleEmitter;

class SingleTaskListenerFactory<Result> implements TaskListenerFactory<Result, SingleEmitter<Result>> {

  @Override
  public OnSuccessListener<Result> createOnSuccessListener(SingleEmitter<Result> emitter) {
    return new SingleEmitterSuccessListener<>(emitter);
  }

  @Override
  public OnFailureListener createOnFailureListener(SingleEmitter<Result> emitter) {
    return new SingleEmitterFailureListener<>(emitter);
  }
}
