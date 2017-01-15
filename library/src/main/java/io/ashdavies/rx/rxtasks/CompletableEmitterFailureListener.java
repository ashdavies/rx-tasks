package io.ashdavies.rx.rxtasks;

import android.support.annotation.NonNull;
import com.google.android.gms.tasks.OnFailureListener;
import io.reactivex.CompletableEmitter;

class CompletableEmitterFailureListener implements OnFailureListener {

  private final CompletableEmitter emitter;

  CompletableEmitterFailureListener(CompletableEmitter emitter) {
    this.emitter = emitter;
  }

  @Override
  public void onFailure(@NonNull Exception exception) {
    emitter.onError(exception);
  }
}
