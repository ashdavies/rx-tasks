package io.ashdavies.rx.rxtasks;

import com.google.android.gms.tasks.OnSuccessListener;
import io.reactivex.SingleEmitter;

class SingleEmitterSuccessListener<T> implements OnSuccessListener<T> {

  private final SingleEmitter<T> emitter;

  SingleEmitterSuccessListener(SingleEmitter<T> emitter) {
    this.emitter = emitter;
  }

  @Override
  public void onSuccess(T t) {
    emitter.onSuccess(t);
  }
}
