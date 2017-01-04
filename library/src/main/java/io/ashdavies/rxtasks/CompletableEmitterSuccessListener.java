package io.ashdavies.rxtasks;

import com.google.android.gms.tasks.OnSuccessListener;
import io.reactivex.CompletableEmitter;

class CompletableEmitterSuccessListener implements OnSuccessListener<Void> {

  private final CompletableEmitter emitter;

  CompletableEmitterSuccessListener(CompletableEmitter emitter) {
    this.emitter = emitter;
  }

  @Override
  public void onSuccess(Void aVoid) {
    emitter.onComplete();
  }
}
