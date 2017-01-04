package io.ashdavies.rx.tasks;

import android.support.annotation.NonNull;
import com.google.android.gms.tasks.OnFailureListener;
import io.reactivex.SingleEmitter;

class SingleEmitterFailureListener<T> implements OnFailureListener {

  private final SingleEmitter<T> emitter;

  SingleEmitterFailureListener(SingleEmitter<T> emitter) {
    this.emitter = emitter;
  }

  @Override
  public void onFailure(@NonNull Exception exception) {
    emitter.onError(exception);
  }
}
