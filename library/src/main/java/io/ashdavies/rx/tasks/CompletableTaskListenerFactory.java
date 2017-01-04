package io.ashdavies.rx.tasks;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import io.reactivex.CompletableEmitter;

class CompletableTaskListenerFactory implements TaskListenerFactory<Void, CompletableEmitter> {

  @Override
  public OnSuccessListener<Void> createOnSuccessListener(CompletableEmitter emitter) {
    return new CompletableEmitterSuccessListener(emitter);
  }

  @Override
  public OnFailureListener createOnFailureListener(CompletableEmitter emitter) {
    return new CompletableEmitterFailureListener(emitter);
  }
}
