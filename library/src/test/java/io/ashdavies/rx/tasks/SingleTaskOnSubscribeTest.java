package io.ashdavies.rx.tasks;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SingleTaskOnSubscribeTest {

  private SingleOnSubscribe<String> onSubscribe;

  @Mock Task<String> task;
  @Mock SingleEmitter<String> emitter;

  @Mock TaskListenerFactory<String, SingleEmitter<String>> factory;
  @Mock OnSuccessListener<String> onSuccessListener;
  @Mock OnFailureListener onFailureListener;

  @Before
  public void setUp() throws Exception {
    onSubscribe = new SingleTaskOnSubscribe<>(task, factory);
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
