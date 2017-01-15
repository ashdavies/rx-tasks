package io.ashdavies.rx.rxtasks;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableOnSubscribe;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CompletableTaskOnSubscribeTest {

  private CompletableOnSubscribe onSubscribe;

  @Mock Task<Void> task;
  @Mock CompletableEmitter emitter;

  @Mock TaskListenerFactory<Void, CompletableEmitter> factory;
  @Mock OnSuccessListener<Void> onSuccessListener;
  @Mock OnFailureListener onFailureListener;

  @Before
  public void setUp() throws Exception {
    onSubscribe = new CompletableTaskOnSubscribe(task, factory);
  }

  @Test
  public void shouldSubscribeWithOnSuccessListener() throws Exception {
    when(factory.createOnSuccessListener(emitter)).thenReturn(onSuccessListener);

    onSubscribe.subscribe(emitter);

    verify(factory, times(1)).createOnSuccessListener(emitter);
    verify(task, times(1)).addOnSuccessListener(onSuccessListener);
  }

  @Test
  public void shouldSubscribeWithOnFailureListener() throws Exception {
    when(factory.createOnFailureListener(emitter)).thenReturn(onFailureListener);

    onSubscribe.subscribe(emitter);

    verify(factory, times(1)).createOnFailureListener(emitter);
    verify(task, times(1)).addOnFailureListener(onFailureListener);
  }
}
