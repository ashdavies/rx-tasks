package io.ashdavies.rxtasks;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

interface TaskListenerFactory<Result, Emitter> {

  OnSuccessListener<Result> createOnSuccessListener(Emitter emitter);

  OnFailureListener createOnFailureListener(Emitter emitter);
}
