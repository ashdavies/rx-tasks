package io.ashdavies.rx.rxtasks;

import com.google.android.gms.tasks.OnSuccessListener;
import io.reactivex.SingleEmitter;
import io.reactivex.annotations.Nullable;

class SingleEmitterSuccessListener<T> implements OnSuccessListener<T> {

  private final SingleEmitter<T> emitter;

  SingleEmitterSuccessListener(SingleEmitter<T> emitter) {
    this.emitter = emitter;
  }

  @Override
  public void onSuccess(@Nullable T t) {
    if (t == null) {
      emitter.onError(new NullPointerException());
    }

    emitter.onSuccess(t);
  }
}
