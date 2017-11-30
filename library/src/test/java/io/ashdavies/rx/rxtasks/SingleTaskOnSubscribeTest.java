package io.ashdavies.rx.rxtasks;

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

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

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
    given(factory.createOnSuccessListener(emitter)).willReturn(onSuccessListener);

    onSubscribe.subscribe(emitter);

    then(factory).should().createOnSuccessListener(emitter);
    then(task).should().addOnSuccessListener(onSuccessListener);
  }

  @Test
  public void shouldSubscribeWithOnFailureListener() throws Exception {
    given(factory.createOnFailureListener(emitter)).willReturn(onFailureListener);

    onSubscribe.subscribe(emitter);

    then(factory).should().createOnSuccessListener(emitter);
    then(task).should().addOnFailureListener(onFailureListener);
  }
}
